package com.hrms.user.controller;

import com.google.gson.Gson;
import com.hrms.common.Utils.CAPTCHAUtils;
import com.hrms.common.Utils.EmailUtils;
import com.hrms.common.domain.CONTANTS;
import com.hrms.common.domain.Msg;
import com.hrms.user.dao.LoginInfoDao;
import com.hrms.user.dao.StaffBaseInfoDao;
import com.hrms.user.dao.StaffCareerInfoDao;
import com.hrms.user.entity.ForgetInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    LoginInfoDao loginInfoDao;
    @Autowired
    StaffBaseInfoDao staffBaseInfoDao;
    @Autowired
    StaffCareerInfoDao staffCareerInfoDao;
    @Autowired
    CAPTCHAUtils captchaUtils;

    @Autowired
    EmailUtils emailUtils;
    private final Gson gson = new Gson();

    /**
     * 邮箱验证
     *
     * @return
     */
    @PostMapping("/pwd/email")
    public String emailCheck(@RequestParam("email") String email) {
        Msg msg = new Msg();
        try {
            if (emailUtils.sendCAPTCHA(email)) {
                msg.setStatus(CONTANTS.STATUS_SUCCESS);
                msg.setContent("验证信息发送成功");
            } else {
                msg.setStatus(CONTANTS.STATUS_WRONG);
                msg.setContent("验证失败，可能是错误的邮箱");
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
            msg.setContent("发送失败，稍后再试");
        }
        return gson.toJson(msg);
    }

    /**
     * 忘记密码时，修改密码
     *
     * @return
     */
    //TODO: 后续应使用线程池或消息队列。
    @PostMapping("/pwd/forget")
    public String forgetPwd(@RequestBody String forgetInfoStr) {
        Msg msg = new Msg();
        msg.setStatus(CONTANTS.STATUS_WRONG);
        try {
            ForgetInfo forgetInfo = gson.fromJson(forgetInfoStr,ForgetInfo.class);
            if(forgetInfo.getEmail().equals(staffBaseInfoDao.getEmailByStaffId(forgetInfo.getStaffId()))){
                if(captchaUtils.cheackCAPTCHA(forgetInfo.getEmail(),forgetInfo.getCAPTCHA())){
                    if(loginInfoDao.changePwd(forgetInfo.getStaffId(),forgetInfo.getUsername(),forgetInfo.getNewPwd())){
                        msg.setStatus(CONTANTS.STATUS_SUCCESS);
                        msg.setContent("修改成功");
                    }else {
                        msg.setContent("用户名或职工号不正确。");
                    }
                }else {
                    msg.setContent("验证码错误。");
                }
            }else {
                msg.setContent("邮箱与职工号不匹配。");
            }
        }catch (Exception e){
            e.printStackTrace();
            msg.setStatus("error");
            msg.setContent("修改失败，稍后再试。");
        }
        return gson.toJson(msg);
    }

    /**
     *用户主动修改密码
     */
    @PostMapping("/pwd/change")
    public String changePwd(){
        return null;
    }
}
