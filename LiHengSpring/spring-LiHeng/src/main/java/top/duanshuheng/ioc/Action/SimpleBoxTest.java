package top.duanshuheng.ioc.Action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.duanshuheng.ioc.entiy.SimpleSomeBean;

public class SimpleBoxTest {
    public static void main(String[] args) {

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");

        SimpleSomeBean simpleSomeBean = (SimpleSomeBean) applicationContext.getBean("simpleSomeBean");

        System.out.println(simpleSomeBean.getVar());
        System.out.println(simpleSomeBean.getStr());
        System.out.println(simpleSomeBean.getC());
    }
}
