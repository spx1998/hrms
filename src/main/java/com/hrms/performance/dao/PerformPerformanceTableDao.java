package com.hrms.performance.dao;

import com.hrms.performance.entity.PerformanceTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (PerformanceTable)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-21 17:28:07
 */
@Repository
@Mapper
public interface PerformPerformanceTableDao {

    List<PerformanceTable> getPerformanceTableList(String month);

    boolean score(@Param("performanceTable") PerformanceTable performanceTable);

    List<PerformanceTable> getHistoryByStaffId(String staffId);
}