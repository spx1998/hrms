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

    private Integer grade;

    private Date hireDate;

    private String seniority;

    private Date contractStart;

    private Date contractEnd;

    private String phoneNumber;

    private String email;

    private String address;

    private String nation;
    private String school;
    private String education;
    private String politicalStatus;
    private int jobId;

    public StaffDetailInfo() {

    }

    public StaffDetailInfo(StaffBaseInfo staffBaseInfo, StaffCareerInfo staffCareerInfo) {
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
        this.hireDate = staffCareerInfo.getHireDate();
        this.contractStart = staffCareerInfo.getContractStart();
        this.contractEnd = staffCareerInfo.getContractEnd();
        this.nation = staffBaseInfo.getNation();
        this.education = staffBaseInfo.getEducation();
        this.politicalStatus = staffBaseInfo.getPoliticalStatus();
        this.school = staffBaseInfo.getSchool();
        this.jobId = staffCareerInfo.getJobId();
    }

    public String getNation() {
        return nation;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
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


    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
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
