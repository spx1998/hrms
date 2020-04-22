package com.hrms.personnel.entity;

import java.io.Serializable;

/**
 * (Reason)实体类
 *
 * @author makejava
 * @since 2020-04-21 13:46:58
 */
public class Reason implements Serializable {
    private static final long serialVersionUID = 162248338246661798L;
    
    private Integer id;
    
    private Integer type;
    
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}