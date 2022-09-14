package disign.Singleton.RegisteredSingleton;

public enum EnumSington {
    INSTANCE;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSington getInstance(){
        return INSTANCE;
    }
}
