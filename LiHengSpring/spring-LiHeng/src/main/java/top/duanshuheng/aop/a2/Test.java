package top.duanshuheng.aop.a2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContextAop2.xml");

        ISomeService someService= (ISomeService) ac.getBean("someServiceImpl");
        IOtherService otherService= (IOtherService) ac.getBean("otherServiceImpl");
        someService.doSome();
        someService.doOther();
        otherService.doSome();
    }
}
