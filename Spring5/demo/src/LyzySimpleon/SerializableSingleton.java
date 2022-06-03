package LyzySimpleon;

import java.io.Serial;
import java.io.Serializable;

//序列化破坏单例的类
public class SerializableSingleton implements Serializable {
    private final static SerializableSingleton INSTANCE =new SerializableSingleton();

    private SerializableSingleton(){}

    public static SerializableSingleton getInstance(){
        return INSTANCE;
    }

//    优化后添加代码
    @Serial
    private Object readResolve(){
        return INSTANCE;
    }
}
