package com.java.model;

public class AppError {
    public int httpStatusCOde;
    public int applicationCode;
    public String message;
    public String link;

    public AppError(int httpStatusCOde, String message) {
        this.httpStatusCOde = httpStatusCOde;
        this.message = message;
    }

}
