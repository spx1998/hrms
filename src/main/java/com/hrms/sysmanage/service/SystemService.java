package com.hrms.sysmanage.service;

import com.hrms.personnel.entity.JobInfo;
import com.hrms.sysmanage.dao.SysDepartmentDao;
import com.hrms.sysmanage.dao.SysDepartmentNumberDao;
import com.hrms.sysmanage.dao.SysJobInfoDao;
import com.hrms.sysmanage.dao.SysStaffCareerInfoDao;
import com.hrms.sysmanage.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SystemService {

    @Autowired
    SysDepartmentDao sysDepartmentDao;

    @Autowired
    SysStaffCareerInfoDao sysStaffCareerInfoDao;

    @Autowired
    SysDepartmentNumberDao sysDepartmentNumberDao;

    @Autowired
    SysJobInfoDao sysJobInfoDao;

    @Transactional
    public void getDepartmentNumbers(List<Department> departments) {
        List<HashMap<String, Object>> list = sysStaffCareerInfoDao.getDepNumMap();
        Map<String, Integer> map = new HashMap<>();
        if (list != null && !list.isEmpty()) {
            for (HashMap<String, Object> hashMap : list) {
                String key = null;
                Integer value = null;
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    if ("key".equals(entry.getKey())) {
                        key = (String) entry.getValue();
                    } else if ("value".equals(entry.getKey())) {
                        value = ((Long) entry.getValue()).intValue();
                    }
                }
                map.put(key, value);
            }
        }
        for (Department department : departments) {
            department.setNumber(map.get(department.getDepartmentId()));
            if (department.getNumber() == null) {
                department.setNumber(0);
            }
        }
    }

    @Transactional
    public boolean createNewDepartment(Department department, String typeStr) throws Exception {
        //生成departmentId
        int number = sysDepartmentDao.countDepartmentByType(typeStr + "%") + 1;
        department.setDepartmentId(typeStr + String.format("%03d", number));
        if (sysStaffCareerInfoDao.checkHr(department.getHrId(), department.getHrName()) == 1) {
            //TODO: 新增部门的负责人该如何处理：现行有问题。
            if (sysStaffCareerInfoDao.checkANdTransferMinister(department.getDepartmentId(), department.getMinisterId(), department.getMinisterName())) {
                sysDepartmentDao.createDepartment(department);
                sysDepartmentNumberDao.createDepartmentNumber(department.getDepartmentId());
                return true;
            } else return false;
        } else return false;
    }

    @Transactional
    public void createJobInfo(JobInfo jobInfo, String status) {
        if (!"enable".equals(status)) {
            sysDepartmentDao.activeDepartment(jobInfo.getDepartmentId());
        }
        sysJobInfoDao.addJobInfo(jobInfo);
    }

    public boolean deleteJobInfo(JobInfo jobInfo) {
        if (sysStaffCareerInfoDao.getJobNumber(jobInfo.getId()) == 0) {
            sysJobInfoDao.deleteJobInfo(jobInfo.getId());
            return true;
        } else return false;
    }

    public boolean deleteDepartment(Department department) {
        if (sysStaffCareerInfoDao.getDepNumber(department.getDepartmentId()) == 0) {
            sysDepartmentDao.deleteDepartment(department.getDepartmentId());
            return true;
        } else return false;
    }
}
