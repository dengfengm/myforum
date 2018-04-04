package com.cn.myforum.bean;

import java.io.Serializable;

public class UserBean implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;




}
