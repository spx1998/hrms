package com.hrms.personnel.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hrms.common.Utils.DateUtils;
import com.hrms.common.domain.CONTANTS;
import com.hrms.common.domain.Msg;
import com.hrms.personnel.dao.*;
import com.hrms.personnel.entity.*;
import com.hrms.personnel.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    PersonnelJobInfoDao personnelJobInfoDao;

    @Autowired
    PersonnelService personnelService;

    @Autowired
    DateUtils dateUtils;

    private final Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd")
            .create();

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
            List<JobInfo> jobInfos = personnelJobInfoDao.getJobList();
            HashMap<String, StaffBaseInfo> staffBaseInfoHashMap = new HashMap<>();
            HashMap<Integer, String> jobHashMap = new HashMap<>();
            for (JobInfo jobInfo : jobInfos) {
                jobHashMap.put(jobInfo.getId(), jobInfo.getName());
            }
            for (StaffBaseInfo staffBaseInfo : staffBaseInfos) {
                staffBaseInfoHashMap.put(staffBaseInfo.getStaffId(), staffBaseInfo);
            }
            for (StaffCareerInfo staffCareerInfo : staffCareerInfos) {
                staffCareerInfo.setJobName(jobHashMap.get(staffCareerInfo.getJobId()));
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
    public String getStaffDetail(@RequestParam("staffId") String staffId) {
        Msg msg = new Msg();
        try {
            StaffBaseInfo staffBaseInfo = personnelStaffBaseInfoDao.getStaffById(staffId);
            StaffCareerInfo staffCareerInfo = personnelStaffCareerInfoDao.getStaffById(staffId);
            staffCareerInfo.setSeniority(dateUtils.yearDifference(new Date(), staffCareerInfo.getHireDate()) + "年" + dateUtils.monthDifference(new Date(), staffCareerInfo.getHireDate()) + "月");
            StaffDetailInfo staffDetailInfo = new StaffDetailInfo(staffBaseInfo, staffCareerInfo);
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(staffDetailInfo));
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 修改员工信息
     */
    @PostMapping("/staff/update")
    public String staffUpdate(@RequestBody String str) {
        Msg msg = new Msg();
        try {
            StaffDetailInfo staffDetailInfo = gson.fromJson(str, StaffDetailInfo.class);
            personnelService.updateStaff(staffDetailInfo);
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
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
    public String createStaffInfo(@RequestBody String jsonStr) {
        Msg msg = new Msg();
        try {
            StaffCreateInfo staffCreateInfo = gson.fromJson(jsonStr, StaffCreateInfo.class);
            //TODO:事务管理
            personnelService.generateStaffInfos(staffCreateInfo);
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 删除待入职人员
     */
    @PostMapping("/staff/pending/del")
    public String deletePendingStaff(@RequestBody String jsonStr) {
        Msg msg = new Msg();
        try {
            JsonObject jsonObject = new JsonParser().parse(jsonStr).getAsJsonObject();
            String staffId = jsonObject.get("staffId").getAsString();
            personnelService.deletePendingStaff(staffId);
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 获取职位列表
     */
    @GetMapping("/staff/job/list")
    public String getJobList() {
        Msg msg = new Msg();
        try {
            List<JobInfo> jobInfos = personnelJobInfoDao.getJobList();
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(jobInfos));
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }
}
