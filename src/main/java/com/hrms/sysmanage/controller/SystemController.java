package com.hrms.sysmanage.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hrms.common.domain.CONTANTS;
import com.hrms.common.domain.Msg;
import com.hrms.sysmanage.dao.SysDepartmentDao;
import com.hrms.sysmanage.dao.SysStaffCareerInfoDao;
import com.hrms.sysmanage.entity.Department;
import com.hrms.sysmanage.service.SystemService;
import com.hrms.sysmanage.utils.DepartmentUtils;
import com.sun.org.apache.bcel.internal.generic.DUP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class SystemController {
    @Autowired
    SysDepartmentDao sysDepartmentDao;

    @Autowired
    SystemService systemService;

    @Autowired
    DepartmentUtils departmentUtils;

    @Autowired
    SysStaffCareerInfoDao sysStaffCareerInfoDao;


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

    /**
     * 新增部门
     */
    @PostMapping("/hrms/department/create")
    public String createNewDepartment(@RequestBody String jsonStr) {
        Msg msg = new Msg();
        try {
            Department department = gson.fromJson(jsonStr, Department.class);
            int type = new JsonParser().parse(jsonStr).getAsJsonObject().get("type").getAsInt();
            String typeStr = String.format("%02d", type);
            systemService.createNewDepartment(department, typeStr);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 修改部门hr
     */
    @PostMapping("/hrms/department/changehr")
    public String changeHr(@RequestBody String str) {
        Msg msg = new Msg();
        try {
            Department department = gson.fromJson(str, Department.class);
            if (sysStaffCareerInfoDao.checkHr(department.getHrId(), department.getHrName()) == 1 && sysDepartmentDao.changeHr(department.getDepartmentId(), department.getHrId(), department.getHrName())) {
                msg.setStatus(CONTANTS.STATUS_SUCCESS);
            } else msg.setStatus(CONTANTS.STATUS_WRONG);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }
}
