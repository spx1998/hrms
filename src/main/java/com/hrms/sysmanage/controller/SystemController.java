package com.hrms.sysmanage.controller;

import com.google.gson.Gson;
import com.hrms.common.domain.CONTANTS;
import com.hrms.common.domain.Msg;
import com.hrms.sysmanage.dao.SysDepartmentDao;
import com.hrms.sysmanage.dao.SysStaffCareerInfoDao;
import com.hrms.sysmanage.entity.Department;
import com.hrms.sysmanage.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class SystemController {
    @Autowired
    SysDepartmentDao sysDepartmentDao;

    @Autowired
    SystemService systemService;

    Gson gson = new Gson();

    /**
     * 获取部门列表
     */
    @GetMapping("/hrms/department/list")
    public String getDepartmentList() {
        Msg msg = new Msg();
        try {
            List<Department> departments = sysDepartmentDao.getDepartmentList();
            systemService.getDepartmentNumbers(departments);
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(departments));
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }
}
