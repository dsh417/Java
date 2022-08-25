package top.duanshuheng.no1.no1text;

import java.util.concurrent.TimeUnit;

public class BlockedThreadInterruptExample extends Thread{

    @Override
    public void run() {

        while(!ThreadStopExample.interrupted()){
            try {
                TimeUnit.SECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();

//                这里做一些线程结束时的，资源回收、后置处理
//                在获得此异常前，已经对中断的标识进行复位-》理由是让线程自己决定何时中断

                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        BlockedThreadInterruptExample blocked=new BlockedThreadInterruptExample();
        blocked.start();
        TimeUnit.MICROSECONDS.sleep(100);
        System.out.println("始りす："+blocked.isInterrupted());
        blocked.interrupt();
        System.out.println("終われました："+blocked.isInterrupted());

    }
}
