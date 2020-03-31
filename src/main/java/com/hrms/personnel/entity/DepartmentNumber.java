package com.hrms.personnel.entity;

import java.io.Serializable;

/**
 * (DepartmentNumber)实体类
 *
 * @author makejava
 * @since 2020-03-31 12:00:36
 */
public class DepartmentNumber implements Serializable {
    private static final long serialVersionUID = 338124610014529450L;
    
    private String departmentId;
    /**
    * 1为正式工，2为实习生。
    */
    private Integer type;
    
    private Integer number;


    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

}