package com.hrms.personnel.dao;

import com.hrms.personnel.entity.StaffCareerInfo;
import com.hrms.personnel.entity.StaffCreateInfo;
import com.hrms.personnel.entity.StaffDetailInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

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

    void createStaffInfo(@Param("staffCreateInfo") StaffCreateInfo staffCreateInfo);

    void deleteStaffInfo(String staffId);

    int updateStaffInfo(@Param("staffDetailInfo") StaffDetailInfo staffDetailInfo);

    int staffTransfer(@Param("staffCareerInfo") StaffCareerInfo staffCareerInfo);

    boolean checkInfo(String staffId, String name);

    List<StaffCareerInfo> getLeavingList(Set<String> staffIds);
}