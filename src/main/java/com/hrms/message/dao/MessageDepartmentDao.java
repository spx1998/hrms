package com.hrms.message.dao;

import com.hrms.message.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Department)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-30 17:22:09
 */
@Mapper
@Repository
public interface MessageDepartmentDao {

    String getDepartmentHr(String applicantId);
}