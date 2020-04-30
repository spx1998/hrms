package com.hrms.performance.dao;

import com.hrms.performance.entity.Reason;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Reason)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-27 15:19:10
 */
@Mapper
@Repository
public interface PerformReasonDao {

    List<Reason> getReasonList();
}