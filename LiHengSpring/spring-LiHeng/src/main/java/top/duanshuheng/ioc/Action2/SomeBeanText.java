package top.duanshuheng.ioc.Action2;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.duanshuheng.ioc.entiy2.ISomeBean;
import top.duanshuheng.ioc.entiy2.SomeBean;
import top.duanshuheng.ioc.entiy2.SomeBeanFactory;

import java.util.Map;

public class SomeBeanText {
    public static void main(String[] args) {
//        ISomeBean someBean=SomeBeanFactory.getiSomeBean();

        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext2.xml");

        ISomeBean someBean= (ISomeBean) ac.getBean("someBean");

        someBean.doSome();


        Map env= (Map) ac.getBean("env");

        System.out.println(JSON.toJSONString(env));

        String javaHome=System.getenv("JAVA_HOME");
        System.out.println(javaHome);
    }
}
