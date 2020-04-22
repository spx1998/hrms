package com.hrms.common.Utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.Period;

@Component
public class DateUtils {
    /**
     * 计算年份差
     */
    public int yearDifference(Date newDate, Date oldDate) {
        LocalDate newLocalDate = new java.sql.Date(newDate.getTime()).toLocalDate();
        LocalDate oldLocalDate = new java.sql.Date(oldDate.getTime()).toLocalDate();
        Period period = Period.between(oldLocalDate, newLocalDate);
        return period.getYears();
    }

    /**
     * 计算月份差
     */
    public int monthDifference(Date newDate, Date oldDate) {
        LocalDate newLocalDate = new java.sql.Date(newDate.getTime()).toLocalDate();
        LocalDate oldLocalDate = new java.sql.Date(oldDate.getTime()).toLocalDate();
        Period period = Period.between(oldLocalDate, newLocalDate);
        return period.getMonths();
    }

    /**
     * 格式化月份
     */
    public String getMonth(Date date) {
        SimpleDateFormat s = new SimpleDateFormat("yyyyMM");
        return s.format(date);
    }
}
