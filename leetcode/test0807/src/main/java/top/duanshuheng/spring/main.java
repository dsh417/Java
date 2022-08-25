package top.duanshuheng.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args) {
        ApplicationContext ac=new  ClassPathXmlApplicationContext("applicationContext.xml");
        talk t= (talk) ac.getBean("someService");
        t.sout();
    }
}
