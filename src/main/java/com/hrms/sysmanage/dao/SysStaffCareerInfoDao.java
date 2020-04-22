package com.hrms.sysmanage.dao;

import com.hrms.personnel.entity.StaffCareerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

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

    boolean checkANdTransferMinister(String departmentId, String ministerId, String ministerName);

    int checkHr(String hrId, String hrName);

    int getJobNumber(Integer id);

    int getDepNumber(String departmentId);

    int staffTransfer(@Param("staffCareerInfo") StaffCareerInfo staffCareerInfo);
}