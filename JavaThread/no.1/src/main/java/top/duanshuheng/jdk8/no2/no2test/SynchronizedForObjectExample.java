package top.duanshuheng.jdk8.no2.no2test;

public class SynchronizedForObjectExample {
//    Object lock=new Object();
    static Object lock=new Object();
    public void m1(){
        synchronized (lock){
            while (true) {
                System.out.println("获取当前线程"+Thread.currentThread().getName());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(()->new SynchronizedForObjectExample().m1(),"t1").start();
        new Thread(()->new SynchronizedForObjectExample().m1(),"t2").start();
    }
}
