package com.hrms.security.dao;

import com.hrms.security.entity.LoginInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LoginInfoDao {

    LoginInfo IDLogin(String account, String password);

    LoginInfo usernameLogin(String account, String password);

    LoginInfo getUserByUsername(String username);

    boolean changePwd(String staffId, String username, String newPwd);

    String getEmailByStaffId(String staffId);

    boolean updatePwd(String staffId, String oldPwd, String newPwd);
}
