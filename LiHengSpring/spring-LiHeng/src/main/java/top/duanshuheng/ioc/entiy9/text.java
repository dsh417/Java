package top.duanshuheng.ioc.entiy9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class text {
    public static void main(String[] args) {

        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext9.xml");


        System.out.println("main ac:"+ac);

        SomeBean someBean= (SomeBean) ac.getBean("someBean");

        someBean.doSome();
    }
}
