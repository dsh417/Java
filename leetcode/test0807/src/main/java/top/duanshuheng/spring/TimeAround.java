package top.duanshuheng.spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TimeAround implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object traget=methodInvocation.getThis();
        Object method=methodInvocation.getMethod();
        Object[] args=methodInvocation.getArguments();

        System.out.println("go");
        long start=System.currentTimeMillis();

        methodInvocation.proceed();

        long end=System.currentTimeMillis();
        System.out.println("end");
        System.out.println("time:"+(end-start));
        return null;
    }
}
