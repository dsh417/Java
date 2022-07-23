package top.duanshuheng.ioc.entiy6;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class text {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext6.xml");

        SomeBean someBean= (SomeBean) ac.getBean("someBean");
        OtherBean otherBean= (OtherBean) ac.getBean("otherBean");

        System.out.println(JSON.toJSONString(someBean));
        System.out.println(JSON.toJSONString(otherBean));
    }
}
