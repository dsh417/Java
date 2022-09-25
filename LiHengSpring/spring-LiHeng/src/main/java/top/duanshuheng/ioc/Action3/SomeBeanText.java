package top.duanshuheng.ioc.Action3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.duanshuheng.ioc.entiy2.ISomeBean;

import java.util.Date;

public class SomeBeanText {
    public static void main(String[] args) {

        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext3.xml");

        ISomeBean someBean= (ISomeBean) ac.getBean("someBean");

        someBean.doSome();


//        Calendar cal=Calendar.getInstance();
//        Date date=cal.getTime();

        Date date= (Date) ac.getBean("date");

        System.out.println(date);
    }
}
