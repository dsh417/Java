package DisignMode.Proxy.StaticProxy.instance;

public class Order {
    private Object oederInfo;
    private Long createTime;
    private String id;

    public void setOederInfo(Object oederInfo) {
        this.oederInfo = oederInfo;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getOederInfo() {
        return oederInfo;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public String getId() {
        return id;
    }
}
