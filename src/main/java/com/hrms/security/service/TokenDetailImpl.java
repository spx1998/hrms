package com.hrms.security.service;


public class TokenDetailImpl implements TokenDetail {

    private final String username;
    private final String staffID;
    private final int roleID;

    public TokenDetailImpl(String staffID, String username, int roleID) {
        this.username = username;
        this.staffID = staffID;
        this.roleID = roleID;
    }

    @Override
    public String getStaffID() {
        return this.staffID;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getRoleID() {
        return this.roleID;
    }
}