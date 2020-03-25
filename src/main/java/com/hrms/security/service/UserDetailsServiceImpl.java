package com.hrms.security.service;

import com.hrms.security.dao.LoginInfoDao;
import com.hrms.security.entity.LoginInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private LoginInfoDao loginInfoDao;

    /**
     * 获取 userDetail
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    //TODO: 此处未必是username 需要确认
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginInfo loginInfo = loginInfoDao.getUserByUsername(username);
        if (loginInfo == null) {
            throw new UsernameNotFoundException("用户名不存在：" + username);
        } else {
            return loginInfo;
        }
    }


}
