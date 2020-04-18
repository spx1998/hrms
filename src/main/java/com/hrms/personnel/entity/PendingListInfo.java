package com.hrms.personnel.entity;

import java.io.Serializable;
import java.util.Date;

public class PendingListInfo implements Serializable {
    private static final long serialVersionUID = -6444424118740973093L;
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

    private Date hireDate;

    private String phoneNumber;

    private String email;

    private String status;

    public PendingListInfo(StaffCareerInfo staffCareerInfo, StaffBaseInfo staffBaseInfo) {
        this.staffId = staffCareerInfo.getStaffId();
        this.name = staffCareerInfo.getName();
        this.departmentId = staffCareerInfo.getDepartmentId();
        this.hireDate = staffCareerInfo.getHireDate();
        this.phoneNumber = staffBaseInfo.getPhoneNumber();
        this.email = staffBaseInfo.getEmail();
        this.status = staffBaseInfo.getStatus();
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

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
