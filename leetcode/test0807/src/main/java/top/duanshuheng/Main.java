package top.duanshuheng;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        eat e= (top.duanshuheng.eat) Proxy.newProxyInstance(dog.class.getClassLoader(), dog.class.getInterfaces(), new LogInvok(new dog()));
        e.eat();
    }

}
class LogInvok implements InvocationHandler{
    Object e;

    public LogInvok(Object e) {
        this.e = e;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("增强后的狗狗");
        return method.invoke(e,args);
    }
}
