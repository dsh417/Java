package entity;

import java.io.Serializable;

public class UserMessage implements Serializable {


    private String appellation;
    private String some;
    private String time;

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public void setSome(String some) {
        this.some = some;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAppellation() {
        return appellation;
    }

    public String getSome() {
        return some;
    }

    public String getTime() {
        return time;
    }
}
