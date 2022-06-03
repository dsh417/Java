package 单例模式;

public class Singleton2 {
    private static Singleton2 s;

    public Singleton2(){

    }

    public static Singleton2 getS() {
        //单例模式，第一次调用这个方法时创建对象
        if(s==null){
            s=new Singleton2();
        }
        return s;
    }
}
