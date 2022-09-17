package top.duanshuheng.aop.a1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.duanshuheng.ioc.entiy2.ISomeBean;

public class main {


    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContextAop1.xml");
        SomeService someService= (SomeService) ac.getBean("someService");
//        someService.doSome();
//        someService.doOther();

        someService.fun(3);
        someService.fun(3);
    }
}
