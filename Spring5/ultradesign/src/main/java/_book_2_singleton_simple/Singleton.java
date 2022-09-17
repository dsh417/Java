package _book_2_singleton_simple;

public class Singleton {
    private Singleton(){}
    private static final Singleton single=new Singleton();
    public static Singleton getInstance(){
        return single;
    }
}
