package com.hrms.personnel.entity;

import java.io.Serializable;

public class StaffListInfo implements Serializable {
    private static final long serialVersionUID = -7576364508793482954L;
    /**
     * 员工编号
     */
    private String staffId;
    /**
     * 员工姓名
     */
    private String name;

    private String departmentId;

    private String departmentName;

    private String grade;

    private String jobName;

    private String phoneNumber;

    private String email;

    public StaffListInfo(StaffCareerInfo staffCareerInfo, StaffBaseInfo staffBaseInfo) {
        this.staffId = staffCareerInfo.getStaffId();
        this.name = staffCareerInfo.getName();
        this.departmentId = staffCareerInfo.getDepartmentId();
        this.grade = staffCareerInfo.getGrade();
        this.phoneNumber = staffBaseInfo.getPhoneNumber();
        this.email = staffBaseInfo.getEmail();
        this.jobName = staffCareerInfo.getJobName();
    }

    public StaffListInfo() {
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
