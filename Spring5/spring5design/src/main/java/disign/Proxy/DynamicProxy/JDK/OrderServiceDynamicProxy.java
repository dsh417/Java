package disign.Proxy.DynamicProxy.JDK;

import disign.Proxy.StaticProxy.instance.DynamicDataSourceEntry;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceDynamicProxy implements InvocationHandler {

    private SimpleDateFormat yearFormat=new SimpleDateFormat("yyyy");
    private Object target;

    public Object getInstance(Object target){
        this.target=target;
        Class<?> clazz=target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        befor(args[0]);
        Object o=method.invoke(target,args);
        after();
        return o;
    }

    private void after() {
        System.out.println("Disign.Proxy after method.");
    }

    private void befor(Object target) {

        try {
            System.out.println("Disign.Proxy before method.");
            Long time= (Long) target.getClass().getMethod("getCreateTime").invoke(target);
            Integer dbRouter=Integer.valueOf(yearFormat.format(new Date(time)));
            System.out.println("静态代理类自动分配到【DB_"+dbRouter+"】数据源处理数据");
            DynamicDataSourceEntry.set(dbRouter);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
