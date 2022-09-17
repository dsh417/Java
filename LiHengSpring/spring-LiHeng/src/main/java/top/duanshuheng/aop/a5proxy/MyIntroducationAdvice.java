package top.duanshuheng.aop.a5proxy;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;

public class MyIntroducationAdvice implements IOtherService, IntroductionInterceptor {

    ISomeService iSomeService;

    @Override
    public void doOther() {
        System.out.println("MyIntroducationAdvice.doOther()");
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        return null;
    }

    @Override
    public boolean implementsInterface(Class<?> intf) {
        
        return false;
    }
}
