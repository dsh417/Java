package disign.Singleton.LazySingleton;

public class ExectorThread implements Runnable{

    @Override
    public void run() {
//        LazySimpleSngleton singleton=LazySimpleSngleton.getInstance();
        LazyDoubleCheckSingleton singleton=LazyDoubleCheckSingleton.getInstance();
//        LazyInnerClassSingleton singleton=LazyInnerClassSingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+"："+singleton);
    }
}
