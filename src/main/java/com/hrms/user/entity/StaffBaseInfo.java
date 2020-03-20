package com.hrms.user.entity;

import java.io.Serializable;

/**
 * (StaffBaseInfo)实体类
 *
 * @author makejava
 * @since 2020-03-19 11:28:08
 */
public class StaffBaseInfo implements Serializable {
    private static final long serialVersionUID = 983508606054897061L;
    /**
    * 员工编号
    */
    private String staffId;
    /**
    * 员工姓名
    */
    private String name;
    
    private String sex;
    
    private Object birthday;
    
    private String phoneNumber;
    
    private String email;
    /**
    * 创建时间
    */
    private Object createTime;
    /**
    * 创建人
    */
    private String createBy;
    /**
    * 最后修改日期
    */
    private Object updateTime;
    /**
    * 最后修改人
    */
    private String updateBy;


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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Object getBirthday() {
        return birthday;
    }

    public void setBirthday(Object birthday) {
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

    public Object getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Object createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Object getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Object updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

}