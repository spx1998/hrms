package com.hrms.sysmanage.service;

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
    SysStaffCareerInfoDao sysStaffCareerInfoDao;

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
                        value = ((Long)entry.getValue()).intValue();
                    }
                }
                map.put(key, value);
            }
        }
        for (Department department : departments) {
            department.setNumber(map.get(department.getDepartmentId()));
            if(department.getNumber()==null){
                department.setNumber(0);
            }
        }
    }

}