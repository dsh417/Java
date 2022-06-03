package 单例模式;

public class Singleton1{
    private static Singleton1 s;

    //单例模式，类加载时候创建对象
    static{
        s=new Singleton1();
    }

    private Singleton1(){
    }

    public static Singleton1 getS() {
        return s;
    }

    }