package com.hrms.security.service;

import com.hrms.security.dao.UserDao;
import com.hrms.security.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

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
        User user = userDao.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在：" + username);
        } else {
            return user;
        }
    }


}
