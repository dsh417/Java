package top.duanshuheng.jdk8.no2synchronized.deadlock;

public class DeadLockExample {
    public static void main(String[] args) {
        Resource res1=new Resource("resource1");
        Resource res2=new Resource("resource2");
        Thread t1=new Thread(()->{
            for (int i = 0; i < 100; i++) {
                res1.saveResouce(res2);
            }});
        Thread t2=new Thread(()->{
            for (int i = 0; i < 100; i++) {
                res2.saveResouce(res1);
            }});
        t1.start();
        t2.start();
    }
}
