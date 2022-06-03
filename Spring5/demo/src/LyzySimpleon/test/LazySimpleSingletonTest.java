package LyzySimpleon.test;

import LyzySimpleon.EndLazyInnerClassSingleton;
import LyzySimpleon.ExectorThread;

public class LazySimpleSingletonTest {
    public static void main(String[] args) {
//        Thread t1=new Thread(new ExectorThread());
//        Thread t2=new Thread(new ExectorThread());
//
//        t1.start();
//        t2.start();
//
//        System.out.println("end");

        //使用EndLazyInnerClassSingleton时候，默认先初始化内部类
        EndLazyInnerClassSingleton e1=EndLazyInnerClassSingleton.getInstance();
//        EndLazyInnerClassSingleton e2=EndLazyInnerClassSingleton.getInstance();
        System.out.println(e1);
//        System.out.println(e2);
    }
}
