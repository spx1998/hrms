package com.hrms.performance.entity;

import java.io.Serializable;

public class PerformanceStaffInfo implements Serializable {
    private static final long serialVersionUID = 5256719465511682294L;
    private String staffId;
    private String name;
    private String month;
    private Integer performanceLevel;
    private String remark;
    private int status;

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPerformanceLevel() {
        return performanceLevel;
    }

    public void setPerformanceLevel(Integer performanceLevel) {
        this.performanceLevel = performanceLevel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
