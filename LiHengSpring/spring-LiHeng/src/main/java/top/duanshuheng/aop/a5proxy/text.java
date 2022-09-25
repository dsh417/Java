package top.duanshuheng.aop.a5proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class text {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContextAop5.xml");

        ISomeService is= (ISomeService) ac.getBean("someService");
        is.doSome();
        ((IOtherService)is).doOther();
    }
}
