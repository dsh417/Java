package top.duanshuheng.jdk8.no2synchronized.deadlock.applylocktest;

public class Resource {
    private String name;
    private int count;

    static ApplyLock applyLock=new ApplyLock();

    public Resource(String name) {
        this.name = name;
    }
    public void statisticsResources(){
        synchronized(this){
            System.out.println("statistics resource");
            count++;
        }
    }
    public void saveResouce(Resource resource){
        applyLock.applyLock(this,resource);
        synchronized (this){
            try {
                System.out.println("save resource");
                resource.statisticsResources();
            }finally {
                applyLock.free(this,resource);
            }
        }
    }
}
