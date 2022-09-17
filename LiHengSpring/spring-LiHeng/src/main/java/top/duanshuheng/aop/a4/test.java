package top.duanshuheng.aop.a4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContextAop4.xml");
        ISomeService is= (ISomeService) ac.getBean("someService");
        IOtherService os= (IOtherService) ac.getBean("otherService");
        is.doOther();
        is.doSome();
        os.doOther();
    }
}
