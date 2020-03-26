package com.hrms.user.entity;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.Date;

/**
 * (Department)实体类
 *
 * @author makejava
 * @since 2020-03-26 15:19:40
 */

public class Department implements Serializable {
    private static final long serialVersionUID = -84331933063587831L;
    
    private String departmentId;
    
    private String name;
    
    private String ministerId;
    
    private String ministerName;
    
    private Date createDate;
    
    private String createBy;


    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMinisterId() {
        return ministerId;
    }

    public void setMinisterId(String ministerId) {
        this.ministerId = ministerId;
    }

    public String getMinisterName() {
        return ministerName;
    }

    public void setMinisterName(String ministerName) {
        this.ministerName = ministerName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

}