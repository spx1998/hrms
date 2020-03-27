package com.hrms.personnel.entity;

import java.io.Serializable;
import java.sql.Date;

public class StaffDetailInfo implements Serializable {

    private static final long serialVersionUID = 6059869838612129097L;

    private String staffId;

    private String name;

    private int sex;

    private Date birthday;

    private String departmentId;

    private String departmentName;

    private String grade;

    private Date hireDate;

    private int seniority;

    private Date contractStart;

    private Date contractEnd;

    private String phoneNumber;

    private String email;

    private String address;

    public StaffDetailInfo() {

    }

    public StaffDetailInfo(StaffBaseInfo staffBaseInfo, StaffCareerInfo staffCareerInfo, Department department) {
        this.staffId = staffBaseInfo.getStaffId();
        this.name = staffBaseInfo.getName();
        this.sex = staffBaseInfo.getSex();
        this.birthday = staffBaseInfo.getBirthday();
        this.address = staffBaseInfo.getAddress();
        this.email = staffBaseInfo.getEmail();
        this.phoneNumber = staffBaseInfo.getPhoneNumber();
        this.departmentId = staffCareerInfo.getDepartmentId();
        this.grade = staffCareerInfo.getGrade();
        this.seniority = staffCareerInfo.getSeniority();
        this.hireDate =staffCareerInfo.getHireDate();
        this.contractStart = staffCareerInfo.getContractStart();
        this.contractEnd = staffCareerInfo.getContractEnd();
        this.departmentName = department.getName();

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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public Date getContractStart() {
        return contractStart;
    }

    public void setContractStart(Date contractStart) {
        this.contractStart = contractStart;
    }

    public Date getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(Date contractEnd) {
        this.contractEnd = contractEnd;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
