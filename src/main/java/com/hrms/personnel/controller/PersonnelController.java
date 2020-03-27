package com.hrms.personnel.controller;

import com.google.gson.Gson;
import com.hrms.common.domain.CONTANTS;
import com.hrms.common.domain.Msg;
import com.hrms.personnel.dao.PersonnelDepartmentDao;
import com.hrms.personnel.dao.PersonnelLoginInfoDao;
import com.hrms.personnel.dao.PersonnelStaffBaseInfoDao;
import com.hrms.personnel.dao.PersonnelStaffCareerInfoDao;
import com.hrms.personnel.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class PersonnelController {
    @Autowired
    PersonnelStaffCareerInfoDao personnelStaffCareerInfoDao;

    @Autowired
    PersonnelStaffBaseInfoDao personnelStaffBaseInfoDao;

    @Autowired
    PersonnelDepartmentDao personnelDepartmentDao;

    @Autowired
    PersonnelLoginInfoDao personnelLoginInfoDao;

    private Gson gson = new Gson();

    /**
     * 获取职员列表
     */
    @GetMapping("/staff/list")
    public String getStaffList() {
        Msg msg = new Msg();
        try {
            List<StaffListInfo> staffListInfos = new ArrayList<>();
            List<StaffBaseInfo> staffBaseInfos = personnelStaffBaseInfoDao.getStaffList();
            List<StaffCareerInfo> staffCareerInfos = personnelStaffCareerInfoDao.getStaffList();
            List<Department> departments = personnelDepartmentDao.getDepartmentList();
            HashMap<String,StaffBaseInfo> staffBaseInfoHashMap = new HashMap<>();
            HashMap<String,String> departmentHashMap = new HashMap<>();
            for(StaffBaseInfo staffBaseInfo:staffBaseInfos){
                staffBaseInfoHashMap.put(staffBaseInfo.getStaffId(),staffBaseInfo);
            }
            for(Department department:departments){
                departmentHashMap.put(department.getDepartmentId(),department.getName());
            }
            for(StaffCareerInfo staffCareerInfo:staffCareerInfos){
                staffListInfos.add(new StaffListInfo(staffCareerInfo,staffBaseInfoHashMap.get(staffCareerInfo.getStaffId()),departmentHashMap.get(staffCareerInfo.getDepartmentId())));
            }
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(staffListInfos));
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
            msg.setContent("获取失败");
        }
        return gson.toJson(msg);
    }

    /**
     * 获取职员详细信息
     */
    @GetMapping("/staff/info")
    public String getStaffInfo(@RequestParam("staffId") String staffId) {
        Msg msg = new Msg();
        try{
            StaffBaseInfo staffBaseInfo = personnelStaffBaseInfoDao.getStaffById(staffId);
            StaffCareerInfo staffCareerInfo = personnelStaffCareerInfoDao.getStaffById(staffId);
            Department department = personnelDepartmentDao.getDepartmentById(staffCareerInfo.getDepartmentId());
            StaffDetailInfo staffDetailInfo = new StaffDetailInfo(staffBaseInfo,staffCareerInfo,department);
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(staffDetailInfo));
        }catch (Exception e){
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 获取部门列表
     */
    @GetMapping("/staff/department/list")
    public String getDepartmentList(){
        Msg msg = new Msg();
        try {
            List<Department> departments = personnelDepartmentDao.getDepartmentList();
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(departments));
        }catch (Exception e){
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }
}
