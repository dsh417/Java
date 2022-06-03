package 多线程;

public class TestThreadA {
    public static void main(String[] args){
        MyThread myThread=new MyThread();

        myThread.start();
//        myThread.run();//自己调用run方法不会启动线程

        for (int i = 0; i < 100; i++) {

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }


    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run");
        }
    }
}
