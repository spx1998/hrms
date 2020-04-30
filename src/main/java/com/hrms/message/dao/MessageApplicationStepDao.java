package com.hrms.message.dao;

import com.hrms.message.entity.ApplicationStep;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (ApplicationStep)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-30 17:17:25
 */
@Mapper
@Repository
public interface MessageApplicationStepDao {
    int getNextStep(Integer type, Integer step);
}