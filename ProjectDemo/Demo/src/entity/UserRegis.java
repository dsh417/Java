package entity;

import java.io.Serializable;

public class UserRegis implements Serializable {
    private String user;
    private String pass;
    private String appellation;

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }
}
