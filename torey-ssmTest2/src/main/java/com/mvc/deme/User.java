package com.mvc.deme;

public class User {
    private int userId;
    private String userName;
    private String remark;
    public User() {
    }

    public User(int userId, String userName, String remark) {
        this.userId = userId;
        this.userName = userName;
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

    //Alt+Insert 生成Get,Set
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
