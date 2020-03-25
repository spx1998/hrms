package com.hrms.user.dao;

import com.hrms.user.entity.StaffBaseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StaffBaseInfoDao {

    StaffBaseInfo getBaseInfoById(String staffId);
}