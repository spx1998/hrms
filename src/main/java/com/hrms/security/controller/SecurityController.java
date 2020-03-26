package com.hrms.security.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hrms.common.Utils.CAPTCHAUtils;
import com.hrms.common.Utils.EmailUtils;
import com.hrms.common.domain.CONTANTS;
import com.hrms.common.domain.Msg;
import com.hrms.security.dao.LoginInfoDao;
import com.hrms.security.dao.ModulesDao;
import com.hrms.security.dao.RoleModuleDao;
import com.hrms.security.dao.SubmodulesDao;
import com.hrms.security.entity.*;
import com.hrms.security.service.TokenDetail;
import com.hrms.security.service.TokenDetailImpl;
import com.hrms.security.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SecurityController {
    private Gson gson = new Gson();
    @Autowired
    LoginInfoDao loginInfoDao;
    @Autowired
    ModulesDao modulesDao;
    @Autowired
    RoleModuleDao roleModuleDao;
    @Autowired
    SubmodulesDao submodulesDao;
    @Autowired
    TokenUtils tokenUtils;
    @Autowired
    CAPTCHAUtils captchaUtils;
    @Autowired
    EmailUtils emailUtils;

    /**
     * 用户登录
     *
     * @param account
     * @param password
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestParam("account") String account, @RequestParam("password") String password) {
        Msg msg = new Msg();
        try {
            LoginInfo loginInfo;
            if ((loginInfo = loginInfoDao.IDLogin(account, password)) != null || (loginInfo = loginInfoDao.usernameLogin(account, password)) != null) {
                //todo: 生成token 并与角色ID一起返回；
                TokenDetail tokenDetail = new TokenDetailImpl(loginInfo.getStaffID(), loginInfo.getUsername(), loginInfo.getRoleID());
                msg.setStatus(CONTANTS.STATUS_SUCCESS);
                msg.setContent(tokenUtils.generateToken(tokenDetail));
            } else {
                msg.setStatus(CONTANTS.STATUS_WRONG);
                msg.setContent("用户名或密码错误");
            }
            return gson.toJson(msg);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
            msg.setContent("登录失败");
            return gson.toJson(msg);
        }
    }

    /**
     * 动态获取主页信息
     *
     * @param token
     * @return
     */
    @GetMapping("/home")
    public String getHomePage(@RequestHeader("token") String token) {
        Msg msg = new Msg();
        try {
            int roleId = tokenUtils.getRoleIDFromToken(token);
            List<Integer> moduleIds = roleModuleDao.getModulesByRole(roleId);
            List<Module> modules = modulesDao.getModules(moduleIds);
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(modules));
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 动态获取导航信息
     *
     */
    @GetMapping("/navigate")
    public String getNavigation(@RequestHeader("token")String token){
        Msg msg =new Msg();
        try {
            int roleId = tokenUtils.getRoleIDFromToken(token);
            List<Integer> moduleIds = roleModuleDao.getModulesByRole(roleId);
            List<Module> modules = modulesDao.getModules(moduleIds);
            List<Submodule> submodules = submodulesDao.getSubmoduleByRole(roleId);
            List<Mod_Submods> mod_submodsList = new ArrayList<>();
            List<Submodule> modSubmods =new ArrayList<>();
            for(Module module:modules){
                for(Submodule submodule:submodules){
                    if(submodule.getModuleId()==module.getModuleId()){
                        modSubmods.add(submodule);
                    }
                }
                mod_submodsList.add(new Mod_Submods(module.getName(),module.getIcon(),modSubmods));
                modSubmods = new ArrayList<>();
            }
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(mod_submodsList));
        }catch (Exception e){
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
            msg.setContent("");
        }
        return gson.toJson(msg);
    }

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
            if(forgetInfo.getEmail().equals(loginInfoDao.getEmailByStaffId(forgetInfo.getStaffId()))){
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
    public String changePwd(@RequestHeader("token") String token, @RequestBody String jsonStr){
        Msg msg = new Msg();
        try {
            String staffId = tokenUtils.getStaffIdFromToken(token);
            JsonObject jsonObject = new JsonParser().parse(jsonStr).getAsJsonObject();
            String newPwd = jsonObject.get("newPwd").getAsString();
            String oldPwd = jsonObject.get("oldPwd").getAsString();
            if(loginInfoDao.updatePwd(staffId,oldPwd,newPwd)){
                msg.setStatus(CONTANTS.STATUS_SUCCESS);
                msg.setContent("修改成功。");
            }else {
                msg.setStatus(CONTANTS.STATUS_WRONG);
                msg.setContent("旧密码错误。");
            }
        }catch (Exception e){
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
            msg.setContent("修改失败，稍后再试。");
        }
        return gson.toJson(msg);
    }
}
