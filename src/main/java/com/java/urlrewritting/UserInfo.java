package com.java.urlrewritting;

public class UserInfo {
    String userInfo;

    public UserInfo() {
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userInfo='" + userInfo + '\'' +
                '}';
    }
}
