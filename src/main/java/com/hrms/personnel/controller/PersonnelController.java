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
import org.springframework.web.bind.annotation.*;

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
            HashMap<String, StaffBaseInfo> staffBaseInfoHashMap = new HashMap<>();
            for (StaffBaseInfo staffBaseInfo : staffBaseInfos) {
                staffBaseInfoHashMap.put(staffBaseInfo.getStaffId(), staffBaseInfo);
            }
            for (StaffCareerInfo staffCareerInfo : staffCareerInfos) {
                staffListInfos.add(new StaffListInfo(staffCareerInfo, staffBaseInfoHashMap.get(staffCareerInfo.getStaffId())));
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
        try {
            StaffBaseInfo staffBaseInfo = personnelStaffBaseInfoDao.getStaffById(staffId);
            StaffCareerInfo staffCareerInfo = personnelStaffCareerInfoDao.getStaffById(staffId);
            Department department = personnelDepartmentDao.getDepartmentById(staffCareerInfo.getDepartmentId());
            StaffDetailInfo staffDetailInfo = new StaffDetailInfo(staffBaseInfo, staffCareerInfo, department);
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(staffDetailInfo));
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 获取部门列表
     */
    @GetMapping("/staff/department/list")
    public String getDepartmentList() {
        Msg msg = new Msg();
        try {
            List<Department> departments = personnelDepartmentDao.getDepartmentList();
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(departments));
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 获取待入职职员列表
     */
    @GetMapping("/staff/pending/list")
    public String getPendingList() {
        Msg msg = new Msg();
        try {
            List<PendingListInfo> pendingListInfos = new ArrayList<>();
            List<StaffBaseInfo> staffBaseInfos = personnelStaffBaseInfoDao.getPendingList();
            List<StaffCareerInfo> staffCareerInfos = personnelStaffCareerInfoDao.getPendingList();
            HashMap<String, StaffBaseInfo> staffBaseInfoHashMap = new HashMap<>();
            for (StaffBaseInfo staffBaseInfo : staffBaseInfos) {
                staffBaseInfoHashMap.put(staffBaseInfo.getStaffId(), staffBaseInfo);
            }
            for (StaffCareerInfo staffCareerInfo : staffCareerInfos) {
                pendingListInfos.add(new PendingListInfo(staffCareerInfo, staffBaseInfoHashMap.get(staffCareerInfo.getStaffId())));
            }
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(pendingListInfos));
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 新建职员信息
     */
    @PostMapping("/staff/create")
    public String createStaffInfo(@RequestBody String jsonStr){
        Msg msg = new Msg();
        try {

            //TODO:事务管理
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }
}
