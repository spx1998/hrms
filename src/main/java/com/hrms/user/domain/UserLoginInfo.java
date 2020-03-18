package com.hrms.user.domain;

import java.io.Serializable;

public class UserLoginInfo implements Serializable {
    private static final long serialVersionUID = -314706673055978251L;
    private String staffID;
    private String username;
    private String password;
    private String roleID;

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
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

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }
}
