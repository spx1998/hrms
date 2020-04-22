package com.hrms.personnel.dao;

import com.hrms.personnel.entity.DisableStaff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (DisableStaff)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-21 13:29:20
 */
@Repository
@Mapper
public interface PersonnelDisableStaffDao {
    void addInfo(@Param("disableStaff") DisableStaff disableStaff);

    List<DisableStaff> getLeavingList();
}