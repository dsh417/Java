package top.duanshuheng.ioc.Action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.duanshuheng.ioc.entiy2.ISomeBean;

public class ImplFactoryText {
    public static void main(String[] args) {

//        SomeBeanFactory factory=new SomeBeanFactory();

        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext2.xml");

        ISomeBean someBean= (ISomeBean) ac.getBean("someBean");

        someBean.doSome();
    }
}
