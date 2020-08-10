package com.java.manager;

import com.java.model.AppError;

public class CrudApiExceptionManager extends RuntimeException{
    private AppError appError;

    public CrudApiExceptionManager(AppError appError) {
        this.appError = appError;
    }

    public AppError getAppError() {
        return appError;
    }

    public void setAppError(AppError appError) {
        this.appError = appError;
    }
}
