package top.duanshuheng.aop.a1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

public class timeAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long bf=System.currentTimeMillis();

        Object o= methodInvocation.getThis();
        Method method=methodInvocation.getMethod();
        Object[] args=methodInvocation.getArguments();

        Object resulet= methodInvocation.proceed();

        long ed=System.currentTimeMillis();

        System.out.println(ed-bf);

        return resulet;
    }
}
