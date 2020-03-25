package com.hrms.user.controller;

import com.google.gson.Gson;
import com.hrms.common.Utils.EmailUtils;
import com.hrms.common.domain.CONTANTS;
import com.hrms.common.domain.Msg;
import com.hrms.security.utils.TokenUtils;
import com.hrms.user.dao.StaffBaseInfoDao;
import com.hrms.user.dao.StaffCareerInfoDao;
import com.hrms.user.entity.StaffBaseInfo;
import com.hrms.user.entity.StaffCareerInfo;
import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

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
    private final Gson gson = new Gson();

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
        }catch (Exception e){
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
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(staffCareerInfo));
        }catch (Exception e){
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
            msg.setContent("");
        }
        return gson.toJson(msg);
    }
}
