package DisignMode.Singleton.RegisteredSingleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//便于管理，但 非线程安全，

//Spring容器式单例，和下列代码相似也是一个hashmap作为容器，通过类名newInstance出实例
public class ContainerSingleton {
    private ContainerSingleton(){}

    private static Map<String,Object> ioc=new ConcurrentHashMap<String,Object>();

    public static Object getBean(String className){
        synchronized (ioc){
            if(!ioc.containsKey(className)){
                Object obj=null;

                try {
                    obj=Class.forName(className).newInstance();
                    ioc.put(className,obj);

                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                return obj;
            }else {
                return ioc.get(className);
            }
        }

    }
}
