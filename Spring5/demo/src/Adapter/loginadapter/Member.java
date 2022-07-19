package Adapter.loginadapter;

public class Member {
    private String username;
    private String password;
    private String mid;
    private String info;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMid() {
        return mid;
    }

    public String getInfo() {
        return info;
    }
}
