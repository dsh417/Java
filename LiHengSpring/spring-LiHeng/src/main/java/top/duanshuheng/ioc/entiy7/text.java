package top.duanshuheng.ioc.entiy7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class text {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext7.xml");



        SomeBean someBean= (SomeBean) ac.getBean("someBean");

        System.out.println(someBean.getOtherBean());

    }
}
