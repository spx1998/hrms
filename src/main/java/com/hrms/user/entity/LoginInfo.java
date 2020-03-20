package com.hrms.user.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;

/**
 * (LoginInfo)实体类
 *
 * @author makejava
 * @since 2020-03-19 11:28:15
 */
public class LoginInfo implements Serializable {
    private static final long serialVersionUID = 868370961111165275L;
    /**
    * 员工编号：5位部门编号，6位个人编号
    */
    private String staffId;
    /**
    * 员工用户名
    */
    private String username;
    /**
    * 密文密码
    */
    private String password;
    
    private Integer roleId;


    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}