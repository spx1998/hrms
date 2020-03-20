package com.hrms.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StaffBaseInfoDao {

    String getEmailByStaffId(String staffId);
}