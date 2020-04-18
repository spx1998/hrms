package com.hrms.sysmanage.entity;

import java.io.Serializable;

/**
 * (DepartmentNumber)实体类
 *
 * @author makejava
 * @since 2020-04-15 10:28:02
 */
public class DepartmentNumber implements Serializable {
    private static final long serialVersionUID = -20531253066545028L;
    
    private Integer id;
    
    private String departmentId;
    /**
    * 1为正式工，2为实习生。
    */
    private Integer type;
    
    private Integer number;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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