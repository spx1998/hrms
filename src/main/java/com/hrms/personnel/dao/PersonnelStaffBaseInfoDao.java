package com.hrms.personnel.dao;

import com.hrms.personnel.entity.StaffBaseInfo;
import com.hrms.personnel.entity.StaffCreateInfo;
import com.hrms.personnel.entity.StaffDetailInfo;
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

    List<StaffBaseInfo> getPendingList();

    void createStaffInfo(@Param("staffCreateInfo")StaffCreateInfo staffCreateInfo);

    void deleteStaffInfo(String staffId);

    int updateStaffInfo(@Param("staffDetailInfo")StaffDetailInfo staffDetailInfo);
}