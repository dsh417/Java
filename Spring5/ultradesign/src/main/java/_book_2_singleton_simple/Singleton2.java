package _book_2_singleton_simple;

public class Singleton2 {
    private Singleton2(){}
    private static Singleton2 single=null;
//    public static Singleton2 getInstance(){
//        if(single==null){
//            single=new Singleton2();
//        }
//        return single;
//    }
//    public static synchronized Singleton2 getInstance(){
////        方法锁极其浪费资源
//        if(single==null){
//            single=new Singleton2();
//        }
//        return single;
//    }
//    public static Singleton2 getInstance(){
////        加了锁，效率仍然不行
//        synchronized (Singleton.class){
//            if(single==null){
//                single=new Singleton2();
//            }
//        }
//        return single;
//    }
}
