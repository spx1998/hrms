package com.hrms.message.entity;

import java.io.Serializable;

/**
 * (ApplicationStep)实体类
 *
 * @author makejava
 * @since 2020-04-30 17:17:25
 */
public class ApplicationStep implements Serializable {
    private static final long serialVersionUID = 563262096344049021L;
    
    private Integer id;
    
    private String name;
    
    private Integer step;
    
    private Integer nextStep;
    
    private Integer type;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Integer getNextStep() {
        return nextStep;
    }

    public void setNextStep(Integer nextStep) {
        this.nextStep = nextStep;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}