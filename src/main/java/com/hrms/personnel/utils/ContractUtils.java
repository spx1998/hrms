package com.hrms.personnel.utils;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Component
public class ContractUtils {
    public Date generateContractEnd(Date contractStart, int contractLength) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(contractStart);
        rightNow.add(Calendar.YEAR,+contractLength);
        //第一个getTime获取Java.util.Date对象，第二个getTime是为了转换为java.sql.Date对象。
        return new java.sql.Date(rightNow.getTime().getTime());
    }
}
