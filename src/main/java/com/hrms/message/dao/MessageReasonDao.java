package com.hrms.message.dao;

import com.hrms.message.entity.Reason;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Reason)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-30 14:27:32
 */
@Mapper
@Repository
public interface MessageReasonDao {

    List<Reason> getReasonList();
}