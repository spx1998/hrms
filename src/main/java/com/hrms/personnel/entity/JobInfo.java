package com.hrms.personnel.entity;

import java.io.Serializable;

/**
 * (JobInfo)实体类
 *
 * @author makejava
 * @since 2020-04-15 16:00:42
 */
public class JobInfo implements Serializable {
    private static final long serialVersionUID = -84731483895231738L;
    
    private Integer id;
    
    private String name;
    
    private String departmentId;
    
    private Integer grade;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

}