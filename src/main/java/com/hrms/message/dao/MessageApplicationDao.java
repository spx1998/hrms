package com.hrms.message.dao;

import com.hrms.message.entity.Application;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Application)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-29 17:25:27
 */

@Mapper
@Repository
public interface MessageApplicationDao {


    List<Application> getApplicationByApprover(String staffId);

    Application getApplicationDetail(Integer id);

    void rejectApplication(Integer id);

    void agreeApplication(Integer id, String nextId, Integer nextStep, String status);
}