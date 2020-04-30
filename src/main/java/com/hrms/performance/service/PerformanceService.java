package com.hrms.performance.service;

import com.hrms.common.Utils.DateUtils;
import com.hrms.performance.dao.*;
import com.hrms.performance.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PerformanceService {
    @Autowired
    PerformPerformanceTableDao performPerformanceTableDao;

    @Autowired
    PerformStaffCareerInfoDao performStaffCareerInfoDao;

    @Autowired
    PerformAbsenceDao performAbsenceDao;

    @Autowired
    PerformDepartmentDao performDepartmentDao;

    @Autowired
    PerformApplicationDao performApplicationDao;

    @Autowired
    DateUtils dateUtils;

    @Transactional
    public List<PerformanceStaffInfo> getPerformanceList(String staffId, String month) {
        //TODO:未打分 需要在月末自动生成
        List<PerformanceStaffInfo> performanceStaffInfos = performStaffCareerInfoDao.getColleagueByStaffId(staffId);
        HashMap<String, PerformanceStaffInfo> hashMap = new HashMap<>();
        for (PerformanceStaffInfo performanceStaffInfo : performanceStaffInfos) {
            performanceStaffInfo.setStatus(0);
            performanceStaffInfo.setMonth(month);
            hashMap.put(performanceStaffInfo.getStaffId(), performanceStaffInfo);
        }
        List<PerformanceTable> performanceTables = performPerformanceTableDao.getPerformanceTableList(month);
        List<PerformanceStaffInfo> list = new ArrayList<>();
        PerformanceStaffInfo p;
        for (PerformanceTable performanceTable : performanceTables) {
            p = hashMap.get(performanceTable.getStaffId());
            p.setRemark(performanceTable.getRemark());
            p.setPerformanceLevel(performanceTable.getPerformanceLevel());
            p.setStatus(1);
            hashMap.put(p.getStaffId(), p);
        }
        for (String key : hashMap.keySet()) {
            list.add(hashMap.get(key));
        }

        return list;
    }

    @Transactional
    public List<Date> getVacationList(String staffId) {
        List<Date> dates = new ArrayList<>();
        List<Absence> absences = performAbsenceDao.getAbsenceByStaffId(staffId);
        for (Absence absence : absences) {
            Calendar begin = Calendar.getInstance();
            begin.setTime(absence.getStartDate());
            while (absence.getEndDate().after(begin.getTime())) {
                dates.add(begin.getTime());
                begin.add(Calendar.DAY_OF_MONTH, 1);
            }
            dates.add(begin.getTime());
        }
        return dates;
    }

    @Transactional
    public boolean vacationApplication(String staffId, Application application) {
        application.setType(1);
        StaffCareerInfo staffCareerInfo = performStaffCareerInfoDao.getStaffById(staffId);
        String minister = performDepartmentDao.getMinisterId(staffCareerInfo.getDepartmentId());
        performApplicationDao.createVacationApplication(staffId, minister, application);
        return true;
    }

    @Transactional
    public boolean cancelLeaving(String staffId, Date newDate, Date lastDate) {
        //TODO: 跨月的情况
        if (newDate.getMonth() == lastDate.getMonth()) {
            performAbsenceDao.updateLastDate(staffId, newDate, lastDate);
        } else {
            Date lastDateOfMonth = dateUtils.getLastDay(newDate);
            performAbsenceDao.deleteAbsence(staffId, lastDate);
            performAbsenceDao.updateLastDate(staffId, newDate, lastDateOfMonth);

        }
        return true;
    }
}
