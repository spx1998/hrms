package com.hrms.message.entity;

import java.io.Serializable;

/**
 * (Reason)实体类
 *
 * @author makejava
 * @since 2020-04-30 14:27:32
 */
public class Reason implements Serializable {
    private static final long serialVersionUID = -92085989545561368L;
    
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