package disign.Singleton.LazySingleton;

public class LazyDoubleCheckSingleton {
    //双检锁
    private static volatile LazyDoubleCheckSingleton lazy=null;

    private LazyDoubleCheckSingleton() {}

    public static LazyDoubleCheckSingleton getInstance(){
        if(lazy==null){
            synchronized (LazyDoubleCheckSingleton.class){
                if(lazy==null){
                    lazy=new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazy;
    }
}
