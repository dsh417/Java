package top.duanshuheng.jdk8.no2synchronized.deadlock;

public class Resource {
    private String name;
    private int count;
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
        synchronized (this){
            System.out.println("save resource");
            resource.statisticsResources();
        }
    }
}
