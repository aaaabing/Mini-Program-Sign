package com.lzr.Entity.dto;

public class signList {
    private String userName;
    private String signTime;
    private String signPlace;

    @Override
    public String toString() {
        return "signList{" +
                "userName='" + userName + '\'' +
                ", signTime='" + signTime + '\'' +
                ", signPlace='" + signPlace + '\'' +
                '}';
    }

    public signList(String userName, String signTime, String signPlace) {
        this.userName = userName;
        this.signTime = signTime;
        this.signPlace = signPlace;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }

    public String getsignPlace() {
        return signPlace;
    }

    public void setsignPlace(String signPlace) {
        this.signPlace = signPlace;
    }
}
