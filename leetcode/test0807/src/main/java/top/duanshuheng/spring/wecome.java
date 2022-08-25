package top.duanshuheng.spring;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class wecome implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("wecome");
    }
}
