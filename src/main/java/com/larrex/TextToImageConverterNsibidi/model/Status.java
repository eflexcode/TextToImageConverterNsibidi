package com.larrex.TextToImageConverterNsibidi.model;

import lombok.Data;


public class Status {

    private String status;

    public Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
