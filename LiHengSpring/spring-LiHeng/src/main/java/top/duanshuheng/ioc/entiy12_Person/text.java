package top.duanshuheng.ioc.entiy12_Person;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class text {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext12.xml");

        Person person= (Person) ac.getBean("person");

        System.out.println(JSON.toJSONString(person));

    }
}
