package top.duanshuheng.ioc.entiy11_LastBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext11.xml");

        SomeBean someBean= (SomeBean) ac.getBean("someBean");

        System.out.println(someBean.getStr());
    }
}
