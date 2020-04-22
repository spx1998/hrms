package com.hrms.personnel.entity;

import java.sql.Date;
import java.io.Serializable;

/**
 * (DisableStaff)实体类
 *
 * @author makejava
 * @since 2020-04-21 13:29:20
 */
public class DisableStaff implements Serializable {
    private static final long serialVersionUID = -39062426146323895L;

    private Integer id;

    private String staffId;

    private String name;

    private Integer reason;

    private Date leaveDate;

    private String content;
    private String departmentId;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public Integer getReason() {
        return reason;
    }

    public void setReason(Integer reason) {
        this.reason = reason;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}