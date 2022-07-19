package DisignMode.Singleton.LazySingleton.head;

import java.io.Serial;
import java.io.Serializable;

public class headerEndSingleton implements Serializable,Cloneable {


    public headerEndSingleton() {
        System.out.printf("构造函数调用");
        if(getSington.h!=null){
            throw new RuntimeException("多个实例");
        }
    }

    public final static headerEndSingleton getInstance(){
        return getSington.h;
    }

    public static class getSington{
        public static final headerEndSingleton h=new headerEndSingleton();
        static {
            System.out.printf("加载静态内部类");
        }
    }

    @Serial
    private Object readResolve(){
        return getSington.h;
    }

    protected Object clone() throws CloneNotSupportedException {
        return getSington.h;
    }

}
