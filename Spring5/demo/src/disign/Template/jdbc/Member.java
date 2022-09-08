package disign.Template.jdbc;

public class Member {
    private String username;
    private String password;
    private String nikeName;

    private int age;
    private String addr;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNikeName() {
        return nikeName;
    }

    public int getAge() {
        return age;
    }

    public String getAddr() {
        return addr;
    }
}
