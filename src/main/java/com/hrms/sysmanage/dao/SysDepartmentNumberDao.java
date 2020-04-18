package com.hrms.sysmanage.dao;

import com.hrms.sysmanage.entity.DepartmentNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (DepartmentNumber)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-15 10:28:02
 */
@Repository
@Mapper
public interface SysDepartmentNumberDao {


    void createDepartmentNumber(String departmentId);
}