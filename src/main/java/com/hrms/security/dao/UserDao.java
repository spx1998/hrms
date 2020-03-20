package com.hrms.security.dao;

import com.hrms.security.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {

    User IDLogin(String account, String password);

    User usernameLogin(String account, String password);

    User getUserByUsername(String username);
}
