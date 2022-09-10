package top.duanshuheng.jdk8.no1interrupt.no1text;

import java.util.concurrent.TimeUnit;

public class InterruptExample extends Thread{
    @Override
    public void run() {
        int i=0;
        while (!Thread.currentThread().isInterrupted()){
            i++;
        }
        System.out.println("わたしわ　終われました"+i);
    }

    public static void main(String[] args) throws InterruptedException{

        InterruptExample interruptExample=new InterruptExample();
        interruptExample.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("始ります：InterruptExample:"+interruptExample.isInterrupted());
        interruptExample.interrupt();
        System.out.println("終われした：InterruptExample:"+interruptExample.isInterrupted());

    }

//    interrupt
}
