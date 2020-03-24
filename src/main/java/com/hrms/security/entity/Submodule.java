package com.hrms.security.entity;

import java.io.Serializable;

/**
 * (Submodules)实体类
 *
 * @author makejava
 * @since 2020-03-24 11:35:55
 */
public class Submodule implements Serializable {
    private static final long serialVersionUID = -92165718996301874L;
    
    private int submoduleId;
    
    private int moduleId;
    
    private String name;

    private String path;

    public int getSubmoduleId() {
        return submoduleId;
    }

    public void setSubmoduleId(int submoduleId) {
        this.submoduleId = submoduleId;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}