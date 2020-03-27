package com.hrms.personnel.entity;

import java.sql.Date;
import java.io.Serializable;

/**
 * (StaffBaseInfo)实体类
 *
 * @author makejava
 * @since 2020-03-27 11:35:10
 */
public class StaffBaseInfo implements Serializable {
    private static final long serialVersionUID = 515654589618565726L;
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
    
    private String phoneNumber;
    
    private String email;

    private String address;

    /**
    * 创建人
    */
    private String createBy;
    /**
    * 创建日期
    */
    private Date createDate;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}