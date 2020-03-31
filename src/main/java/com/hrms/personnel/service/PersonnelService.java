package com.hrms.personnel.service;

import com.hrms.common.Utils.PinyinUtils;
import com.hrms.personnel.dao.*;
import com.hrms.personnel.entity.StaffCreateInfo;
import com.hrms.personnel.utils.ContractUtils;
import com.hrms.personnel.utils.StaffUtils;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    DepartmentNumberDao departmentNumberDao;

    @Autowired
    StaffUtils staffUtils;

    @Autowired
    ContractUtils contractUtils;

    @Autowired
    PinyinUtils pinyinUtils;

    @Transactional
    public void generateStaffInfos(StaffCreateInfo staffCreateInfo) throws BadHanyuPinyinOutputFormatCombination {
        //TODO:每年重置number
        int number = departmentNumberDao.getNumberByDepartmentIdAndType(staffCreateInfo.getDepartmentId(), staffCreateInfo.getType());
        staffCreateInfo.setStaffId(staffUtils.generateStaffId(staffCreateInfo,number));
        staffCreateInfo.setContractEnd(contractUtils.generateContractEnd(staffCreateInfo.getContractStart(),staffCreateInfo.getContractLength()));
        personnelStaffBaseInfoDao.createStaffInfo(staffCreateInfo);
        personnelStaffCareerInfoDao.createStaffInfo(staffCreateInfo);
        String username = pinyinUtils.castToPinyin(staffCreateInfo.getName()) +number;
        int roleId ;
        if(staffCreateInfo.getDepartmentId().equals("01001")){
            roleId = 3;
        }else roleId = 1;
        if(staffCreateInfo.getGrade()==1){
            roleId +=1;
        }
        personnelLoginInfoDao.createLoginInfo(staffCreateInfo,username,roleId);
    }

    @Transactional
    public void deletePendingStaff(String staffId) {
        personnelLoginInfoDao.deleteStaffInfo(staffId);
        personnelStaffBaseInfoDao.deleteStaffInfo(staffId);
        personnelStaffCareerInfoDao.deleteStaffInfo(staffId);
    }
}
