package com.hrms.sysmanage.dao;

import com.hrms.personnel.entity.JobInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (JobInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-20 11:00:23
 */
@Repository
@Mapper
public interface SysJobInfoDao {
    List<JobInfo> getJobList();

    void addJobInfo(@Param("jobInfo") JobInfo jobInfo);

    void deleteJobInfo(Integer id);
}