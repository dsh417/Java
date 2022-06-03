package LyzySimpleon;

public class LazySimpleSingleton {
    private LazySimpleSingleton(){}

    private static LazySimpleSingleton lazy=null;
//    完美展现synchronized,但是线程数量多会导致大批量阻塞，降低性能，修改为双重检查锁的单例模式
    public synchronized static LazySimpleSingleton getInstance(){
        if (lazy==null) {
            lazy=new LazySimpleSingleton();
        }
        return lazy;
    }
//    public static LazySimpleSngleton getInstance(){
//        if (lazy==null) {
//            lazy=new LazySimpleSngleton();
//        }
//        return lazy;
//    }
}
