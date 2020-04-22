package com.hrms.personnel.dao;

import com.hrms.personnel.entity.StaffCreateInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * (LoginInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-27 11:35:01
 */
@Repository
@Mapper
public interface PersonnelLoginInfoDao {

    void createLoginInfo(StaffCreateInfo staffCreateInfo, String username, int roleId);

    void deleteStaffInfo(String staffId);

    boolean updateRoles(String staffId, int role);
}