package com.example.demo.controller;

public class User {
    private String username;
    private String password;
    private Integer uid;

    private Double gold;


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public void setGold(Double gold) {
        this.gold = gold;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getUid() {
        return uid;
    }

    public Double getGold() {
        return gold;
    }
}
