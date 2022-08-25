package top.duanshuheng.no1.no1text;

public class ThreadStopExample extends Thread{
    @Override
    public void run() {

        try {
            for (int i = 0; i < 100000; i++) {
                System.out.println("行きます："+i);
            }
            System.out.println("終われました。。");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException{

        ThreadStopExample t1=new ThreadStopExample();
        t1.start();
        Thread.sleep(100);
        t1.stop();

    }

//    可见，stop方法使得pringtln的同步锁synchronized释放，极其危险

}
