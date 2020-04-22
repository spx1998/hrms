package com.hrms.performance.entity;

import java.sql.Date;
import java.io.Serializable;

/**
 * (StaffCareerInfo)实体类
 *
 * @author makejava
 * @since 2020-04-21 17:26:51
 */
public class StaffCareerInfo implements Serializable {
    private static final long serialVersionUID = 669715031823866530L;
    
    private String staffId;
    
    private String name;
    
    private String departmentId;
    
    private Date hireDate;
    
    private String grade;
    
    private Integer jobId;
    
    private Date contractStart;
    
    private Integer contractLength;
    
    private Date contractEnd;
    
    private String status;


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

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Date getContractStart() {
        return contractStart;
    }

    public void setContractStart(Date contractStart) {
        this.contractStart = contractStart;
    }

    public Integer getContractLength() {
        return contractLength;
    }

    public void setContractLength(Integer contractLength) {
        this.contractLength = contractLength;
    }

    public Date getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(Date contractEnd) {
        this.contractEnd = contractEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}