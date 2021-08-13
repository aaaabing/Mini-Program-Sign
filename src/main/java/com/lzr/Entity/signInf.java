package com.lzr.Entity;

public class signInf {
    private int id;
    private String signTime;
    private String userName;
    private String signPlace;

    @Override
    public String toString() {
        return "signInf{" +
                "id=" + id +
                ", signTime='" + signTime + '\'' +
                ", userName='" + userName + '\'' +
                ", signPlace='" + signPlace + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSignPlace() {
        return signPlace;
    }

    public void setSignPlace(String signPlace) {
        this.signPlace = signPlace;
    }

    public signInf(String signTime, String userName, String signPlace) {
        this.signTime = signTime;
        this.userName = userName;
        this.signPlace = signPlace;
    }
}
