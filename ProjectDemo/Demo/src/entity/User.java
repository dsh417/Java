package entity;

import java.io.Serializable;

public class User implements Serializable {

    Integer uid;
    String user;
    String pass;
    Integer gold;
    String time;
    Integer attennum;
    Integer extnum;
    String appellation;

    public User(){
        super();
    }

    public Integer getUid() {
        return uid;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public Integer getGold() {
        return gold;
    }

    public String getTime() {
        return time;
    }

    public Integer getAttennum() {
        return attennum;
    }

    public Integer getExtnum() {
        return extnum;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setAttennum(Integer attennum) {
        this.attennum = attennum;
    }

    public void setExtnum(Integer extnum) {
        this.extnum = extnum;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }
}
