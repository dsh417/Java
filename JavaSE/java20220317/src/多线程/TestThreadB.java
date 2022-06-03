package 多线程;

public class TestThreadB {
    public static void main(String[] args) {

        MyRunnable myRunnable=new MyRunnable();

        Thread t1=new Thread(myRunnable);
        t1.start();

        Thread t2=new Thread(myRunnable);
        t2.start();

//        for (int i = 0; i < 100; i++) {
//            try {
//                Thread.sleep(5);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("jjj");
//        }
    }
}
//thread和Runnable优缺点
/*
*   Thread简单便于开发
*   Runnable可以自由继承另一个类
*   Runnable可以传递给多个线程实现资源共享
*   Runnable减少创建新线程实例需要的内存和cpu时间
*
* */
class MyRunnable implements Runnable{
    private int i=1;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            this.i++;
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("rrr"+this.i);
        }
    }
}
class My2Thread extends Thread{
    private int i=1;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ttt"+i);
        }
    }
}