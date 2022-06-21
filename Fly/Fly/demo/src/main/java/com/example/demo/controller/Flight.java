package com.example.demo.controller;
/*
* 航班实体类
*
*   private String carrier;航班公司
    private Integer flightNo;航班号
    private Long departureDatetime;起飞时间
    private Long arrivalDatetime;到达时间
    private String departure;起飞点
    private String arrival;到达点
    private String num;座位最大值
*
*
* */
public class Flight {
    private String carrier;
    private Integer fid;
    private Long departureDatetime;
    private Long arrivalDatetime;
    private String departure;
    private String arrival;
    private String num;

    public void setNum(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public void setFlightNo(Integer flightNo) {
        this.fid = flightNo;
    }

    public void setDepartureDatetime(Long departureDatetime) {
        this.departureDatetime = departureDatetime;
    }

    public void setArrivalDatetime(Long arrivalDatetime) {
        this.arrivalDatetime = arrivalDatetime;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getCarrier() {
        return carrier;
    }

    public Integer getFlightNo() {
        return fid;
    }

    public Long getDepartureDatetime() {
        return departureDatetime;
    }

    public Long getArrivalDatetime() {
        return arrivalDatetime;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }
}
