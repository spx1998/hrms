package com.hrms.personnel.entity;

import java.sql.Date;
import java.io.Serializable;

/**
 * (Department)实体类
 *
 * @author makejava
 * @since 2020-03-27 11:34:41
 */
public class Department implements Serializable {
    private static final long serialVersionUID = -55966221248568051L;
    private String departmentId;

    private String name;

    private String ministerId;

    private String ministerName;

    private String hrId;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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

    public String getHrId() {
        return hrId;
    }

    public void setHrId(String hrId) {
        this.hrId = hrId;
    }

}