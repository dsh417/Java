package DisignMode.Adapter.Project;

public class UMeUser {
    private int OPEN_ID;
    private String mod;
    private Object o;

    public UMeUser(int OPEN_ID, String mod, Object o) {
        this.OPEN_ID = OPEN_ID;
        this.mod = mod;
        this.o = o;
    }

    public void setOPEN_ID(int OPEN_ID) {
        this.OPEN_ID = OPEN_ID;
    }

    public void setMod(String mod) {
        this.mod = mod;
    }

    public void setO(Object o) {
        this.o = o;
    }

    public int getOPEN_ID() {
        return OPEN_ID;
    }

    public String getMod() {
        return mod;
    }

    public Object getO() {
        return o;
    }
}
