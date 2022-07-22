package top.duanshuheng.ioc.Action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import top.duanshuheng.ioc.Service.UserService;

public class test {
    public static void main(String[] args) {

        Resource resource=new ClassPathResource("applicationContext.xml");

//        BeanFactory bf = new XmlBeanFactory(resource);

        ApplicationContext ac=new ClassPathXmlApplicationContext(new String[]{ "applicationContext.xml"});

        UserService userService= (UserService) ac.getBean("userService");

        userService.regist();
    }

}
