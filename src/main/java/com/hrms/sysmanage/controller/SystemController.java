package com.hrms.sysmanage.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hrms.common.domain.CONTANTS;
import com.hrms.common.domain.Msg;
import com.hrms.personnel.entity.JobInfo;
import com.hrms.personnel.entity.StaffCareerInfo;
import com.hrms.sysmanage.dao.SysJobInfoDao;
import com.hrms.sysmanage.dao.SysDepartmentDao;
import com.hrms.sysmanage.dao.SysStaffCareerInfoDao;
import com.hrms.sysmanage.entity.Department;
import com.hrms.sysmanage.service.SystemService;
import com.hrms.sysmanage.utils.DepartmentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    SysJobInfoDao sysJobInfoDao;


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
            if (systemService.createNewDepartment(department, typeStr)) {
                msg.setStatus(CONTANTS.STATUS_SUCCESS);
            } else msg.setStatus(CONTANTS.STATUS_WRONG);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 修改部门hr
     */
    @PostMapping("/hrms/department/update")
    public String updateDepartment(@RequestBody String str) {
        Msg msg = new Msg();
        try {
            Department department = gson.fromJson(str, Department.class);
            if (sysStaffCareerInfoDao.checkHr(department.getHrId(), department.getHrName()) == 1 && sysDepartmentDao.updateDepartment(department.getDepartmentId(), department.getName(), department.getHrId(), department.getHrName())) {
                msg.setStatus(CONTANTS.STATUS_SUCCESS);
            } else msg.setStatus(CONTANTS.STATUS_WRONG);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 获取新建部门列表
     */
    @GetMapping("/hrms/building/list")
    public String getBuildingList() {
        Msg msg = new Msg();
        try {
            List<Department> departments = sysDepartmentDao.getBuildingList();
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(departments));
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 删除新建部门
     */
    @PostMapping("/hrms/building/del")
    public String deleteBuildingDepartment(@RequestBody String jsonStr) {
        Msg msg = new Msg();
        try {
            Department department = gson.fromJson(jsonStr, Department.class);
            sysDepartmentDao.deleteBuildingDepartment(department.getDepartmentId());
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 获取全部部门列表
     */
    @GetMapping("/hrms/department/list/all")
    public String getAllDepartmentList() {
        Msg msg = new Msg();
        try {
            List<Department> departments = sysDepartmentDao.getAllDepartments();
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(departments));
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 获取职务列表
     */
    @GetMapping("/hrms/job/list")
    public String getJobList() {
        Msg msg = new Msg();
        try {
            List<JobInfo> jobInfos = sysJobInfoDao.getJobList();
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(jobInfos));
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 新增岗位
     */
    @PostMapping("/hrms/job/create")
    public String createJobInfo(@RequestBody String jsonStr) {
        Msg msg = new Msg();
        try {
            JobInfo jobInfo = gson.fromJson(jsonStr, JobInfo.class);
            JsonObject jsonObject = new JsonParser().parse(jsonStr).getAsJsonObject();
            String status = jsonObject.get("status").getAsString();
            systemService.createJobInfo(jobInfo, status);
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setContent(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 删除职位信息
     */
    @PostMapping("/hrms/job/del")
    public String deleteJobInfo(@RequestBody String jsonStr) {
        Msg msg = new Msg();
        try {
            JobInfo jobInfo = gson.fromJson(jsonStr, JobInfo.class);
            if (systemService.deleteJobInfo(jobInfo))
                msg.setStatus(CONTANTS.STATUS_SUCCESS);
            else msg.setStatus(CONTANTS.STATUS_WRONG);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setContent(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 删除部门
     */
    @PostMapping("/hrms/department/del")
    public String deleteDepartment(@RequestBody String jsonStr) {
        Msg msg = new Msg();
        try {
            Department department = gson.fromJson(jsonStr, Department.class);
            if (systemService.deleteDepartment(department))
                msg.setStatus(CONTANTS.STATUS_SUCCESS);
            else msg.setStatus(CONTANTS.STATUS_WRONG);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setContent(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }


}
