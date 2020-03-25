package com.hrms.user.dao;

import com.hrms.user.entity.StaffCareerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StaffCareerInfoDao {


    StaffCareerInfo getCareerInfoById(String staffId);
}