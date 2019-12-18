package com.webkeyz.batchtwotraining.response;

public class ErrorResponse {
    private int code;
    private String message;

    public ErrorResponse() {
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return message;
    }
}
