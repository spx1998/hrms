package com.hrms.personnel.dao;

import com.hrms.personnel.entity.Reason;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Reason)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-21 13:46:58
 */
@Mapper
@Repository
public interface PersonnelReasonDao {

    List<Reason> getReasonList();
}