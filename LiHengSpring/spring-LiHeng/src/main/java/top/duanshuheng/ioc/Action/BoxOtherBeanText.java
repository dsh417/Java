package top.duanshuheng.ioc.Action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.duanshuheng.ioc.entiy.SomeBean;

public class BoxOtherBeanText {
    public static void main(String[] args) {

        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");

        SomeBean someBean= (SomeBean) ac.getBean("someBean");

        System.out.println(someBean.getOb());

    }
}
