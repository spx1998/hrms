package com.hrms.personnel.dao;

import com.hrms.personnel.entity.StaffBaseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (StaffBaseInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-27 11:35:10
 */
@Repository
@Mapper
public interface PersonnelStaffBaseInfoDao {

    List<StaffBaseInfo> getStaffList();

    StaffBaseInfo getStaffById(String staffId);
}