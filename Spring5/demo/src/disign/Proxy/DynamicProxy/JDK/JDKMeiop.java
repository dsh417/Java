package disign.Proxy.DynamicProxy.JDK;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKMeiop implements InvocationHandler {

    //被代理对象
    private Object target;
    public Object getInstance(Object target) throws Exception{
        this.target=target;

        Class<?> clazz=target.getClass();
//        System.out.println(clazz);
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        befor();
        Object obj=method.invoke(this.target,args);
        after();
        return obj;
    }

    private void after() {
        System.out.println("如果合适的话，就准备办事");
    }

    private void befor() {
        System.out.println("我是媒婆，我要给你找对象，现在已经确认你的需求");
        System.out.println("开始物色");
    }
}
