package com.hrms.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginInfoDao {

    boolean changePwd(String staffId, String username, String newPwd);
}