package com.hrms.performance.dao;

import com.hrms.performance.entity.PerformanceStaffInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (StaffCareerInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-21 17:26:51
 */
@Repository
@Mapper
public interface PerformStaffCareerInfoDao {

    List<PerformanceStaffInfo> getColleagueByStaffId(String staffId);
}