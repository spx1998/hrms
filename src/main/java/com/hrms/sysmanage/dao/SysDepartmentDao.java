package com.hrms.sysmanage.dao;

import com.hrms.sysmanage.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * (Department)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-31 17:29:17
 */
@Repository
@Mapper
public interface SysDepartmentDao {

    List<Department> getDepartmentList();

    int countDepartmentByType(String typeStr);

    void createDepartment(@Param("department") Department department);

    boolean changeHr(String departmentId, String hrId, String hrName);
}