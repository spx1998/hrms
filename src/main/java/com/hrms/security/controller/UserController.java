package com.hrms.security.controller;

import com.google.gson.Gson;
import com.hrms.common.domain.Msg;
import com.hrms.security.dao.UserDao;
import com.hrms.security.domain.User;
import com.hrms.security.service.TokenDetail;
import com.hrms.security.service.TokenDetailImpl;
import com.hrms.security.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private Gson g = new Gson();
    @Autowired
    UserDao userDao;
    @Autowired
    TokenUtils tokenUtils;

    @PostMapping("/login")
    public String login(@RequestParam("account") String account, @RequestParam("password") String password) {
        Msg msg = new Msg();
        try {
            User user;
            if ((user = userDao.IDLogin(account, password)) != null || (user = userDao.usernameLogin(account, password)) != null) {
                //todo: 生成token 并与角色ID一起返回；
                TokenDetail tokenDetail = new TokenDetailImpl(user.getStaffID(), user.getUsername(), user.getRoleID());
                msg.setStatus("ok");
                msg.setContent(tokenUtils.generateToken(tokenDetail));
            } else {
                msg.setStatus("wrong");
                msg.setContent("用户名或密码错误");
            }
            return g.toJson(msg);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus("error");
            msg.setContent("登录失败");
            return g.toJson(msg);
        }
    }
}
