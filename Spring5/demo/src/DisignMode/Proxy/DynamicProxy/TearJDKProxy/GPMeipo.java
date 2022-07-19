package DisignMode.Proxy.DynamicProxy.TearJDKProxy;

import java.lang.reflect.Method;

public class GPMeipo implements GPInvocationHandler {
    //被代理的对象，把引用保存下来
    private Object traget;

    public Object getInstance(Object traget)throws Exception{
        this.traget=traget;

        Class<?> clazz=traget.getClass();
        //新建一个类加载器并动态创建文件到类字节码目录、实现所有的接口
        return GPProxy.newProxyInstance(new GPClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(this.traget,args);
        after();
        return null;
    }

    private void after() {
        System.out.println("如果合适的话，就准备办事");
    }

    private void before() {
        System.out.println("我是媒婆，我要给你找对象，现在已经确认你的需求");
        System.out.println("开始物色");
    }
}
