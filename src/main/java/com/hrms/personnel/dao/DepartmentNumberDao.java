package com.hrms.personnel.dao;

import com.hrms.personnel.entity.DepartmentNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (DepartmentNumber)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-31 12:00:36
 */
@Repository
@Mapper
public interface DepartmentNumberDao {
    int getNumberByDepartmentIdAndType(String departmentId, int type);
}