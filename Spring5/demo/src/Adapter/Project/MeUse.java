package Adapter.Project;

public class MeUse {
    private String user;
    private String pass;
    private String emil;

    public MeUse(String user, String pass, String emil) {
        this.user = user;
        this.pass = pass;
        this.emil = emil;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setEmil(String emil) {
        this.emil = emil;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getEmil() {
        return emil;
    }
}
