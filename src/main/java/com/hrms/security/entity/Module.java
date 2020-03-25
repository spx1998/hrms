package com.hrms.security.entity;

import java.io.Serializable;

/**
 * (Modules)实体类
 *
 * @author makejava
 * @since 2020-03-20 14:38:11
 */
public class Module implements Serializable {
    private static final long serialVersionUID = 444003876386556729L;

    private int moduleId;

    private String name;

    private String url;

    private String icon;


    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}