package com.hrms.sysmanage.dao;

import com.hrms.sysmanage.entity.StaffCareerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (StaffCareerInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-31 20:36:43
 */
@Repository
@Mapper
public interface SysStaffCareerInfoDao {
    List<HashMap<String,Object>> getDepNumMap();
}