package com.hrms.performance.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hrms.common.Utils.DateUtils;
import com.hrms.common.domain.CONTANTS;
import com.hrms.common.domain.Msg;
import com.hrms.performance.dao.PerformAbsenceDao;
import com.hrms.performance.dao.PerformPerformanceTableDao;
import com.hrms.performance.dao.PerformReasonDao;
import com.hrms.performance.dao.PerformStaffCareerInfoDao;
import com.hrms.performance.entity.*;
import com.hrms.performance.service.PerformanceService;
import com.hrms.security.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PerformanceController {
    @Autowired
    PerformPerformanceTableDao performPerformanceTableDao;

    @Autowired
    PerformStaffCareerInfoDao performStaffCareerInfoDao;

    @Autowired
    PerformReasonDao performReasonDao;

    @Autowired
    PerformAbsenceDao performAbsenceDao;

    @Autowired
    PerformanceService performanceService;

    @Autowired
    TokenUtils tokenUtils;

    @Autowired
    DateUtils dateUtils;

    private final Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd")
            .create();

    /**
     * 获取本月考核清单
     */
    @GetMapping("/performance/staff/list")
    public String getPerformanceList(@RequestHeader("token") String token) {
        Msg msg = new Msg();
        try {
            String staffId = tokenUtils.getStaffIdFromToken(token);
            String month = dateUtils.getMonth(new Date());
            List<PerformanceStaffInfo> performanceStaffInfos = performanceService.getPerformanceList(staffId, month);
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(performanceStaffInfos));
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 获取某月考核清单
     */
    @GetMapping("/performance/month/list")
    public String getMonthPerformanceList(@RequestParam("month") String month, @RequestHeader("token") String token) {
        Msg msg = new Msg();
        try {
            String staffId = tokenUtils.getStaffIdFromToken(token);
            List<PerformanceStaffInfo> performanceStaffInfos = performanceService.getPerformanceList(staffId, month);
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(performanceStaffInfos));
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 员工评分
     */
    @PostMapping("/performance/score")
    public String score(@RequestBody String jsonStr) {
        Msg msg = new Msg();
        try {
            PerformanceTable performanceTable = gson.fromJson(jsonStr, PerformanceTable.class);
            if (performPerformanceTableDao.score(performanceTable)) {
                msg.setStatus(CONTANTS.STATUS_SUCCESS);
            } else msg.setStatus(CONTANTS.STATUS_WRONG);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 绩效历史
     */
    @GetMapping("/performance/history")
    public String getHistory(@RequestHeader("token") String token) {
        Msg msg = new Msg();
        try {
            String staffId = tokenUtils.getStaffIdFromToken(token);
            List<PerformanceTable> list = performPerformanceTableDao.getHistoryByStaffId(staffId);
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(list));
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 获取假期列表
     */
    @GetMapping("/performance/vacation/list")
    public String getVacationList(@RequestHeader("token") String token) {
        Msg msg = new Msg();
        try {
            String staffId = tokenUtils.getStaffIdFromToken(token);
            List<Date> vacation = performanceService.getVacationList(staffId);
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(vacation));
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 获取原因列表
     */
    @GetMapping("/performance/vacation/reason/list")
    public String getReasonList() {
        Msg msg = new Msg();
        try {
            List<Reason> list = performReasonDao.getReasonList();
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(list));
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 请假
     */
    @PostMapping("/performance/vacation/application")
    public String vacationApplication(@RequestHeader("token") String token, @RequestBody String jsonStr) {
        Msg msg = new Msg();
        try {
            String staffId = tokenUtils.getStaffIdFromToken(token);
            Application application = gson.fromJson(jsonStr, Application.class);
            if (performanceService.vacationApplication(staffId, application)) {
                msg.setStatus(CONTANTS.STATUS_SUCCESS);
            } else msg.setStatus(CONTANTS.STATUS_WRONG);

        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 销假
     */
    @PostMapping("/performance/vacation/cancel")
    public String cancelLeaving(@RequestHeader("token") String token, @RequestBody String jsonStr) {
        Msg msg = new Msg();
        try {
            String staffId = tokenUtils.getStaffIdFromToken(token);
            UpdateAbsenceDate updateAbsenceDate = gson.fromJson(jsonStr, UpdateAbsenceDate.class);
            if (performanceService.cancelLeaving(staffId,updateAbsenceDate.getNewDate(),updateAbsenceDate.getLastDate())) {
                msg.setStatus(CONTANTS.STATUS_SUCCESS);
            } else msg.setStatus(CONTANTS.STATUS_WRONG);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }
}
