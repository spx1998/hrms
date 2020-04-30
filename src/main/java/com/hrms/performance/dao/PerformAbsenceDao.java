package com.hrms.performance.dao;

import com.hrms.performance.entity.Absence;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * (Absence)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-23 16:53:39
 */
@Repository
@Mapper
public interface PerformAbsenceDao {

    List<Absence> getAbsenceByStaffId(String staffId);

    void updateLastDate(String staffId, Date newDate, Date lastDate);

    void deleteAbsence(String staffId, Date lastDate);
}