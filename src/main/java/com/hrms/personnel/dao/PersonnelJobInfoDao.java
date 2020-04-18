package com.hrms.personnel.dao;

import com.hrms.personnel.entity.JobInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (JobInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-15 16:00:42
 */
@Repository
@Mapper
public interface PersonnelJobInfoDao {

    List<JobInfo> getJobList();

    String getNameById(Integer jobId);
}