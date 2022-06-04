package Singleton.test;

import Singleton.LazySingleton.ExectorThread;
import Singleton.ThreadLoacalSington.ThreadLocalSingleton;

public class ThreadLocalSingletonTest {
    public static void main(String[] args) {
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());

        Thread t1=new Thread(new ExectorThread());
        Thread t2=new Thread(new ExectorThread());

        t1.start();
        t2.start();
        System.out.println("end");
    }
}
