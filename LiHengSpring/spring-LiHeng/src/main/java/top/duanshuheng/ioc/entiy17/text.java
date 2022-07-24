package top.duanshuheng.ioc.entiy17;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class text {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext17.xml");

        SomeBean someBean= (SomeBean) ac.getBean("someBean");

        System.out.println(JSON.toJSONString(someBean));
    }
}
