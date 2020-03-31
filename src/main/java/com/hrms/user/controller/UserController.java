package com.hrms.user.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hrms.common.Utils.EmailUtils;
import com.hrms.common.domain.CONTANTS;
import com.hrms.common.domain.Msg;
import com.hrms.personnel.service.PersonnelService;
import com.hrms.security.utils.TokenUtils;
import com.hrms.user.dao.DepartmentDao;
import com.hrms.user.dao.StaffBaseInfoDao;
import com.hrms.user.dao.StaffCareerInfoDao;
import com.hrms.user.entity.StaffBaseInfo;
import com.hrms.user.entity.StaffCareerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    StaffBaseInfoDao staffBaseInfoDao;
    @Autowired
    StaffCareerInfoDao staffCareerInfoDao;
    @Autowired
    EmailUtils emailUtils;
    @Autowired
    TokenUtils tokenUtils;
    @Autowired
    DepartmentDao departmentDao;
    private Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd")
            .create();

    /**
     * 获取基本资料
     */
    @GetMapping("/info/base")
    public String getBaseInfo(@RequestHeader("token") String token) {
        Msg msg = new Msg();
        try {
            String staffId = tokenUtils.getStaffIdFromToken(token);
            StaffBaseInfo staffBaseInfo = staffBaseInfoDao.getBaseInfoById(staffId);
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(staffBaseInfo));
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
            msg.setContent("");
        }
        return gson.toJson(msg);
    }


    /**
     * 获取职业资料
     */
    @GetMapping("/info/career")
    public String getCareerInfo(@RequestHeader("token") String token) {
        Msg msg = new Msg();
        try {
            String staffId = tokenUtils.getStaffIdFromToken(token);
            StaffCareerInfo staffCareerInfo = staffCareerInfoDao.getCareerInfoById(staffId);
            staffCareerInfo.setDepartmentName(departmentDao.getDepartmentNameById(staffCareerInfo.getDepartmentId()));
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(staffCareerInfo));
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
            msg.setContent("");
        }
        return gson.toJson(msg);
    }

    /**
     * 修改基本资料
     */
    @PostMapping("/info/base/update")
    public String updateBaseInfo(@RequestBody String infoStr) {
        Msg msg = new Msg();
        try {
            JsonObject infoJson = new JsonParser().parse(infoStr).getAsJsonObject();
            String staffId = infoJson.get("staffId").getAsString();
            String email = infoJson.get("email").getAsString();
            String phoneNumber = infoJson.get("phoneNumber").getAsString();
            String address = infoJson.get("address").getAsString();
            if(staffBaseInfoDao.updateInfoByStaffId(staffId,email,phoneNumber,address)){
                msg.setStatus(CONTANTS.STATUS_SUCCESS);
            }else {
                msg.setStatus(CONTANTS.STATUS_WRONG);
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }
}
