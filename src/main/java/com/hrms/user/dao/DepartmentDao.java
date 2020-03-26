package com.hrms.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * (Department)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-26 15:19:40
 */
@Repository
@Mapper
public interface DepartmentDao {


    String getDepartmentNameById(String departmentId);
}