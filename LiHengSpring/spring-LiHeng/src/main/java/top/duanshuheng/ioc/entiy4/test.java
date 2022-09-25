package top.duanshuheng.ioc.entiy4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {

//        延迟实例化，即懒加载（容器创建好了不会给你创建bean
//        Resource resource =new ClassPathResource("applicationContext4.xml");

//        BeanFactory bf=new XmlBeanFactory(resource);


//        预先实例化（默认，可配置
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext4.xml");

        System.out.println("-----------");
        SomeBean someBean= (SomeBean) ac.getBean("someBean");
    }
}
