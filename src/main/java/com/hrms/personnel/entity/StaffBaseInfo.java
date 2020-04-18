package com.hrms.personnel.entity;

import java.sql.Date;
import java.io.Serializable;

/**
 * (StaffBaseInfo)实体类
 *
 * @author makejava
 * @since 2020-04-15 16:25:25
 */
public class StaffBaseInfo implements Serializable {
    private static final long serialVersionUID = 538843568489746424L;
    /**
    * 员工编号
    */
    private String staffId;
    /**
    * 员工姓名
    */
    private String name;
    /**
    * 0男性；1女性
    */
    private Integer sex;
    
    private Date birthday;
    
    private String education;
    
    private String school;
    
    private String nation;
    
    private String politicalStatus;
    
    private String phoneNumber;
    
    private String email;
    
    private String address;
    /**
    * 创建后为create，完成薪资建表后为pending，激活后为enable，离职后为disable。
    */
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}