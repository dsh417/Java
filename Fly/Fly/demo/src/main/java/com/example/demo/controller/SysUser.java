package com.example.demo.controller;

/*
* 用户对航班是一对多
*
* */

import java.util.List;

public class SysUser {
    private String username;
    private String password;
    private int uid;
    private List<Flight> flightList;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getUid() {
        return uid;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }
}
