package com.hrms.message.dao;

import com.hrms.message.entity.StaffCareerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * (StaffCareerInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-29 17:26:16
 */

@Mapper
@Repository
public interface MessageStaffCareerInfoDao {
    List<StaffCareerInfo> getStaffInfos(Set<String> keySet);

    String getNameByStaffId(String staffId);
}