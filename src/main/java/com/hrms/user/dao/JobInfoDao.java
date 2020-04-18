package com.hrms.user.dao;

import com.hrms.user.entity.JobInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (JobInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-15 15:49:10
 */
@Mapper
@Repository
public interface JobInfoDao {
    String getNameById(Integer jobId);
}