package com.hrms.personnel.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.io.Serializable;

/**
 * (StaffCareerInfo)实体类
 *
 * @author makejava
 * @since 2020-03-27 11:35:15
 */
public class StaffCareerInfo implements Serializable {
    private static final long serialVersionUID = 515881444826694374L;

    private String staffId;

    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hireDate;

    private Integer grade;

    private String departmentId;
    private Integer jobId;
    private String jobName;
    /**
     *
     */
    private String seniority;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date contractStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Integer contractLength;

    private Date contractEnd;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
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

}