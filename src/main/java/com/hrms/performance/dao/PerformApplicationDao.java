package com.hrms.performance.dao;

import com.hrms.performance.entity.Application;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Application)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-27 15:30:31
 */
@Mapper
@Repository
public interface PerformApplicationDao {

    void createVacationApplication(@Param("staffId") String staffId,@Param("ministerId") String minister,@Param("application") Application application);
}