package com.hrms.performance.dao;

import com.hrms.performance.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Department)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-27 15:45:16
 */
@Mapper
@Repository
public interface PerformDepartmentDao {
    String getMinisterId(String departmentId);
}