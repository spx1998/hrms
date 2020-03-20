package com.hrms.security.controller;

import com.google.gson.Gson;
import com.hrms.common.domain.CONTANTS;
import com.hrms.common.domain.Msg;
import com.hrms.security.dao.ModulesDao;
import com.hrms.security.dao.RoleModuleDao;
import com.hrms.security.dao.UserDao;
import com.hrms.security.entity.Module;
import com.hrms.security.entity.User;
import com.hrms.security.service.TokenDetail;
import com.hrms.security.service.TokenDetailImpl;
import com.hrms.security.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SecurityController {
    private Gson gson = new Gson();
    @Autowired
    UserDao userDao;
    @Autowired
    ModulesDao modulesDao;
    @Autowired
    RoleModuleDao roleModuleDao;
    @Autowired
    TokenUtils tokenUtils;

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
            User user;
            if ((user = userDao.IDLogin(account, password)) != null || (user = userDao.usernameLogin(account, password)) != null) {
                //todo: 生成token 并与角色ID一起返回；
                TokenDetail tokenDetail = new TokenDetailImpl(user.getStaffID(), user.getUsername(), user.getRoleID());
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
}
