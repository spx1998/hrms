package com.hrms.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Date;

/**
 * (StaffCareerInfo)实体类
 *
 * @author makejava
 * @since 2020-03-25 15:33:34
 */
public class StaffCareerInfo implements Serializable {
    private static final long serialVersionUID = 732687066701309078L;
    
    private String staffId;
    
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date hireDate;
    
    private String grade;
    
    private String departmentId;
    private String departmentName;
    private Integer jobId;
    private String jobName;
    /**
    * 工龄 需要有函数修改 还有签约日期 到期时间 工资 工资卡号 备注等属性
    */
    private String seniority;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")

    private Date contractStart;
    
    private Integer contractLength;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date contractEnd;


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

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getSeniority() {
        return seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
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

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
}