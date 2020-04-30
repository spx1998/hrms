package com.hrms.personnel.service;

import com.hrms.common.Utils.PinyinUtils;
import com.hrms.personnel.dao.*;
import com.hrms.personnel.entity.DisableStaff;
import com.hrms.personnel.entity.StaffCareerInfo;
import com.hrms.personnel.entity.StaffCreateInfo;
import com.hrms.personnel.entity.StaffDetailInfo;
import com.hrms.personnel.utils.ContractUtils;
import com.hrms.personnel.utils.StaffUtils;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service

public class PersonnelService {
    @Autowired
    PersonnelStaffCareerInfoDao personnelStaffCareerInfoDao;

    @Autowired
    PersonnelStaffBaseInfoDao personnelStaffBaseInfoDao;

    @Autowired
    PersonnelDepartmentDao personnelDepartmentDao;

    @Autowired
    PersonnelLoginInfoDao personnelLoginInfoDao;

    @Autowired
    PersonnelDepartmentNumberDao personnelDepartmentNumberDao;

    @Autowired
    PersonnelDisableStaffDao personnelDisableStaffDao;

    @Autowired
    StaffUtils staffUtils;

    @Autowired
    ContractUtils contractUtils;

    @Autowired
    PinyinUtils pinyinUtils;

    @Transactional
    public void generateStaffInfos(StaffCreateInfo staffCreateInfo) throws BadHanyuPinyinOutputFormatCombination {
        //TODO:每年重置number
        int number = personnelDepartmentNumberDao.getNumberByDepartmentIdAndType(staffCreateInfo.getDepartmentId(), staffCreateInfo.getType());
        staffCreateInfo.setStaffId(staffUtils.generateStaffId(staffCreateInfo, number));
        staffCreateInfo.setContractEnd(contractUtils.generateContractEnd(staffCreateInfo.getContractStart(), staffCreateInfo.getContractLength()));
        personnelStaffBaseInfoDao.createStaffInfo(staffCreateInfo);
        personnelStaffCareerInfoDao.createStaffInfo(staffCreateInfo);
        String username = pinyinUtils.castToPinyin(staffCreateInfo.getName()) + number;
        int roleId;
        if (staffCreateInfo.getDepartmentId().equals("01001")) {
            roleId = 3;
        } else roleId = 1;
        if (staffCreateInfo.getGrade() == 1) {
            roleId += 1;
        }
        personnelLoginInfoDao.createLoginInfo(staffCreateInfo, username, roleId);
    }

    @Transactional
    public void deletePendingStaff(String staffId) {
        personnelLoginInfoDao.deleteStaffInfo(staffId);
        personnelStaffBaseInfoDao.deleteStaffInfo(staffId);
        personnelStaffCareerInfoDao.deleteStaffInfo(staffId);
    }

    @Transactional
    public void updateStaff(StaffDetailInfo staffDetailInfo) throws Exception {
        if (personnelStaffBaseInfoDao.updateStaffInfo(staffDetailInfo) != 1 || personnelStaffCareerInfoDao.updateStaffInfo(staffDetailInfo) != 1) {
            throw new Exception();
        }
    }

    @Transactional
    public boolean staffTransfer(StaffCareerInfo staffCareerInfo) throws Exception {
        int role = 1;
        if (staffCareerInfo.getDepartmentId().equals("01001")) {
            role = 3;
        }
        if (staffCareerInfo.getGrade() == 1) {
            role += 1;
        }
        if (personnelStaffCareerInfoDao.staffTransfer(staffCareerInfo) == 1) {
            if (personnelLoginInfoDao.updateRoles(staffCareerInfo.getStaffId(), role)) {
                return true;
            } else throw new Exception();
        } else return false;

    }

    @Transactional
    public boolean dismissStaff(DisableStaff disableStaff) {
        //TODO:到期设置员工离职
        if (personnelStaffCareerInfoDao.checkInfo(disableStaff.getStaffId(), disableStaff.getName())) {
            personnelDisableStaffDao.addInfo(disableStaff);
            return true;
        } else return false;
    }

    public List<DisableStaff> getLeavingList() {
        List<DisableStaff> disableStaffs = personnelDisableStaffDao.getLeavingList();
        HashMap<String, DisableStaff> hashMap = new HashMap<>();
        for (DisableStaff disableStaff : disableStaffs) {
            hashMap.put(disableStaff.getStaffId(), disableStaff);
        }
        if (hashMap.isEmpty()) return disableStaffs;
        List<StaffCareerInfo> staffCareerInfos = personnelStaffCareerInfoDao.getLeavingList(hashMap.keySet());
        DisableStaff disableStaff;
        for (StaffCareerInfo staffCareerInfo : staffCareerInfos) {
            disableStaff = hashMap.get(staffCareerInfo.getStaffId());
            disableStaff.setName(staffCareerInfo.getName());
            disableStaff.setDepartmentId(staffCareerInfo.getDepartmentId());
        }
        return disableStaffs;
    }
}
