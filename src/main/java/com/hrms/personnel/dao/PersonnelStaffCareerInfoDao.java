package com.hrms.personnel.dao;

import com.hrms.personnel.entity.StaffCareerInfo;
import com.hrms.personnel.entity.StaffCreateInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (StaffCareerInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-27 11:35:15
 */
@Repository
@Mapper
public interface PersonnelStaffCareerInfoDao {

    List<StaffCareerInfo> getStaffList();

    StaffCareerInfo getStaffById(String staffId);

    List<StaffCareerInfo> getPendingList();

    void createStaffInfo(@Param("staffCreateInfo")StaffCreateInfo staffCreateInfo);

    void deleteStaffInfo(String staffId);
}