package LyzySimpleon.test;

import LyzySimpleon.EndLazyInnerClassSingleton;
import LyzySimpleon.LazyInnerClassSingleton;

import java.lang.reflect.Constructor;

public class LazyInnerClassSingletonTest {
    public static void main(String[] args) {
        try {
            //反射破坏单例
            Class<?> clazz= EndLazyInnerClassSingleton.class;
//            Class<?> clazz= LazyInnerClassSingleton.class;
//
            //获取构造方法
            Constructor c=clazz.getDeclaredConstructor(null);

            //强制访问
            c.setAccessible(true);

//            //暴力初始化
            System.out.println("初始化之前-----------------");
            Object o1=c.newInstance();
//            Object o2=c.newInstance();
//
            System.out.println(o1);
//            System.out.println(o2);
//            System.out.println(o1==o2);
//            //执行结果False

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
