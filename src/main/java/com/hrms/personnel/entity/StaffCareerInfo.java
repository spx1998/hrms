package com.hrms.personnel.entity;

import java.sql.Date;
import java.io.Serializable;

/**
 * (StaffCareerInfo)实体类
 *
 * @author makejava
 * @since 2020-03-27 11:35:15
 */
public class StaffCareerInfo implements Serializable {
    private static final long serialVersionUID = 515881444826694374L;
    
    private String staffId;
    
    private String name;
    
    private Date hireDate;
    
    private String grade;
    
    private String departmentId;
    /**
    * 工龄 需要有函数修改 还有签约日期 到期时间 工资 工资卡号 备注等属性
    */
    private Integer seniority;
    
    private Date contractStart;
    
    private Integer contractLength;
    
    private Date contractEnd;


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

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
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

    public Date getContractStart() {
        return contractStart;
    }

    public void setContractStart(Date contractStart) {
        this.contractStart = contractStart;
    }

    public Integer getContractLength() {
        return contractLength;
    }

    public void setContractLength(Integer contractLength) {
        this.contractLength = contractLength;
    }

    public Date getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(Date contractEnd) {
        this.contractEnd = contractEnd;
    }

}