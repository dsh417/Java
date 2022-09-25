package top.duanshuheng.aop.a5proxy;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;

import java.lang.reflect.Method;

public class MyIntroducationAdvice implements IOtherService, IntroductionInterceptor {

    ISomeService iSomeService;


    @Override
    public void doOther() {
        System.out.println("MyIntroducationAdvice.doOther()");
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
//        如果是IOtherService的方法，
//          应该调用自己的对应的方法
//        如果调用的不是引入的方法，
//          应该调用目标方法

//        方法是谁？所以应该先获取
        Method method=invocation.getMethod();
//        怎么知道方法在哪个类型里？不是getClass。
        Class<?> c=method.getDeclaringClass();
        if(implementsInterface(c)){
//            Arguments：参数
            return method.invoke(this,invocation.getArguments());
        }

//            这样调用自己的方法
        return invocation.proceed();
    }

//    判断传入的东西是否实现了IOtherService接口
    @Override
    public boolean implementsInterface(Class<?> intf) {
//        intf instanceof IOtherService 不能使用这个！intf不是对象，要对象才可以
//        使用isAssignableFrom方法 this是它的父类
//        IOtherService是否是它的父类->前面是父类，后面是子类
        return IOtherService.class.isAssignableFrom(intf);
    }
}
