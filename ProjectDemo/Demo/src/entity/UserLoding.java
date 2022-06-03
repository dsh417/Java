package entity;

import java.io.Serializable;

public class UserLoding implements Serializable {

    private String user;
    private String pass;

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
