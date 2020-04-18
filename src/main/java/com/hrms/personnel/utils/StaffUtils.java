package com.hrms.personnel.utils;

import com.hrms.personnel.entity.StaffCreateInfo;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class StaffUtils {

    public String generateStaffId(StaffCreateInfo staffCreateInfo, int number) {
        String staffId;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int year = calendar.get(Calendar.YEAR);
        staffId = staffCreateInfo.getDepartmentId() + staffCreateInfo.getType() + (year - 2000) + String.format("%03d", number);
        return staffId;
    }
}
