package com.hrms.performance.entity;

import java.io.Serializable;
import java.util.Date;

public class UpdateAbsenceDate implements Serializable {

    private static final long serialVersionUID = -1556230932181148991L;
    private Date newDate;
    private Date lastDate;

    public Date getNewDate() {
        return newDate;
    }

    public void setNewDate(Date newDate) {
        this.newDate = newDate;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }
}
