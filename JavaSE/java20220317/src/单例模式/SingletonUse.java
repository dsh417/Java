package 单例模式;

public class SingletonUse {
    //单例模式

    public static void main(String[] args) {
        //多次创建只有一个对象
        Singleton1 s1=Singleton1.getS();
        Singleton1 s2=Singleton1.getS();
        Singleton1 s3=Singleton1.getS();
        Singleton1 s4=Singleton1.getS();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);

        Singleton2 s5=Singleton2.getS();
        Singleton2 s6=Singleton2.getS();
        Singleton2 s7=Singleton2.getS();
        Singleton2 s8=Singleton2.getS();
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(s7);
        System.out.println(s8);
    }
}
