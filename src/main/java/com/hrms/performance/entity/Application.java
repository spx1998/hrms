package com.hrms.performance.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * (Application)实体类
 *
 * @author makejava
 * @since 2020-04-27 15:30:31
 */
public class Application implements Serializable {
    private static final long serialVersionUID = 644250557070034336L;
    
    private Integer id;
    /**
    * 申请人工号
    */
    private String applicantId;
    /**
    * 审批人工号
    */
    private String approverId;
    /**
    * 1为请假，2为补贴，3为调动，4为离职
    */
    private Integer type;
    
    private String reason;
    
    private Date startDate;
    
    private Date endDate;
    
    private String copy;
    
    private String content;
    
    private Date createTime;
    
    private Date updateTime;
    /**
    * processing是申请中，approve是批准，reject是拒绝
    */
    private String status;
    /**
    * 0为完成，1为第一次审批，2为第二次审批，根据type决定审批次数。
    */
    private Integer step;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getApproverId() {
        return approverId;
    }

    public void setApproverId(String approverId) {
        this.approverId = approverId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCopy() {
        return copy;
    }

    public void setCopy(String copy) {
        this.copy = copy;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

}