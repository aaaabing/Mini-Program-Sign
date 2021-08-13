package com.lzr.Entity.dto;

public class Cond {
    private Long  con;
    private String token;

    public Cond(Long con, String token) {
        this.con = con;
        this.token = token;
    }

    @Override
    public String toString() {
        return "Cond{" +
                "con=" + con +
                ", token='" + token + '\'' +
                '}';
    }

    public Long getCon() {
        return con;
    }

    public void setCon(Long con) {
        this.con = con;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
