package com.hrms.security.entity;

import java.io.Serializable;

/**
 * (RoleModule)实体类
 *
 * @author makejava
 * @since 2020-03-20 14:38:11
 */
public class RoleModule implements Serializable {
    private static final long serialVersionUID = 437939002759058034L;
    
    private Integer id;
    
    private Integer roleId;
    
    private Integer moduleId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

}