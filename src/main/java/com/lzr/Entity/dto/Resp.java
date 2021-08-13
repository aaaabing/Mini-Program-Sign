package com.lzr.Entity.dto;

public class Resp {
    String token;

    @Override
    public String toString() {
        return "Resp{" +
                "token='" + token + '\'' +
                '}';
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Resp(String token) {
        this.token = token;
    }
}
