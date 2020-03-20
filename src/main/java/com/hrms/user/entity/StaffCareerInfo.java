package com.hrms.user.entity;

import java.io.Serializable;

/**
 * (StaffCareerInfo)实体类
 *
 * @author makejava
 * @since 2020-03-19 11:27:40
 */
public class StaffCareerInfo implements Serializable {
    private static final long serialVersionUID = -78362625985835915L;
    
    private String staffId;
    
    private String name;
    
    private Object hireDate;
    
    private String grade;
    
    private String departmentId;
    /**
    * 工龄 需要有函数修改 还有签约日期 到期时间 工资 工资卡号 备注等属性
    */
    private Integer seniority;


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

    public Object getHireDate() {
        return hireDate;
    }

    public void setHireDate(Object hireDate) {
        this.hireDate = hireDate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getSeniority() {
        return seniority;
    }

    public void setSeniority(Integer seniority) {
        this.seniority = seniority;
    }

}