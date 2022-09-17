package top.duanshuheng.aop.a3pointcut;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContextAop3.xml");
        ISomeService someService= (ISomeService) ac.getBean("someService"   );
        someService.doSome();
        someService.doOther();
    }
}
