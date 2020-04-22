package com.hrms.performance.entity;

import java.io.Serializable;

/**
 * (PerformanceTable)实体类
 *
 * @author makejava
 * @since 2020-04-21 18:25:51
 */
public class PerformanceTable implements Serializable {
    private static final long serialVersionUID = -65499857603564353L;
    
    private Integer id;
    
    private String staffId;
    
    private String month;
    /**
    * 满分100分
    */
    private Integer performanceLevel;
    /**
    * 备注
    */
    private String remark;


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

}