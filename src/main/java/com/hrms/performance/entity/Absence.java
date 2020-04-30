package com.hrms.performance.entity;

import java.sql.Date;
import java.io.Serializable;

/**
 * (Absence)实体类
 *
 * @author makejava
 * @since 2020-04-23 16:53:39
 */
public class Absence implements Serializable {
    private static final long serialVersionUID = 726030728826481926L;
    
    private Integer id;
    
    private String staffId;
    
    private String month;
    
    private Integer type;
    
    private Date startDate;
    
    private Date endDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}