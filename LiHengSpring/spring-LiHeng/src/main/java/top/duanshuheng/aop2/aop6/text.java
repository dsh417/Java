package top.duanshuheng.aop2.aop6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class text {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContextAop6.xml");

        ISomeService is= (ISomeService) ac.getBean("someService2");
        IOtherService os= (IOtherService) ac.getBean("otherService2");

        is.doSome();
        is.doOther();
        try {
            os.doSome();
        } catch (Exception e) {
            System.out.println("-------");
        }
        os.doOther("zbc");
    }
}
