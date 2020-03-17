package com.hrms.common.domain;

import java.io.Serializable;

public class Msg  implements Serializable {
    private static final long serialVersionUID = -3706345178640521970L;
    private String status;
    private String content;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
