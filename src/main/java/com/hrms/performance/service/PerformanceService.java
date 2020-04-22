package com.hrms.performance.service;

import com.hrms.common.Utils.DateUtils;
import com.hrms.performance.dao.PerformPerformanceTableDao;
import com.hrms.performance.dao.PerformStaffCareerInfoDao;
import com.hrms.performance.entity.PerformanceStaffInfo;
import com.hrms.performance.entity.PerformanceTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class PerformanceService {
    @Autowired
    PerformPerformanceTableDao performPerformanceTableDao;

    @Autowired
    PerformStaffCareerInfoDao performStaffCareerInfoDao;

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
}
