package com.hrms.personnel.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * (DepartmentNumber)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-31 12:00:36
 */
@Repository
@Mapper
public interface PersonnelDepartmentNumberDao {
    int getNumberByDepartmentIdAndType(String departmentId, int type);
}