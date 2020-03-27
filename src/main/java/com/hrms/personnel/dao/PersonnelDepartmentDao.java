package com.hrms.personnel.dao;

import com.hrms.personnel.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Department)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-27 11:34:45
 */
@Repository
@Mapper
public interface PersonnelDepartmentDao {

    List<Department> getDepartmentList();

    Department getDepartmentById(String departmentId);
}