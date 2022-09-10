package top.duanshuheng.jdk8.no2synchronized.no2test;

import org.openjdk.jol.info.ClassLayout;

public class ClassLayoutExample {
    public static void main(String[] args) {
        ClassLayoutExample example=new ClassLayoutExample();
//        JOL打印内存布局
        System.out.println(ClassLayout.parseInstance(example).toPrintable());
    }
}
