package top.duanshuheng.jdk8.no2.no2test;

public class SychronizedExample {
    public void m1(){
        synchronized(SychronizedExample.class){
            while (true) {
                System.out.println("当前访问进程："+Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SychronizedExample s1=new SychronizedExample();
        SychronizedExample s2=new SychronizedExample();
        new Thread(()->s1.m1(),"t1").start();
        new Thread(()->s2.m1(),"t2").start();
    }
}
