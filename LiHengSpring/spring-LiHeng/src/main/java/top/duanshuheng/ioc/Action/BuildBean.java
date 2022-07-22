package top.duanshuheng.ioc.Action;

import com.alibaba.fastjson.JSON;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.duanshuheng.ioc.entiy.BuildMethodBean;

public class BuildBean {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext cpa=new ClassPathXmlApplicationContext("applicationContext.xml");

        BuildMethodBean buildMethodBean= (BuildMethodBean) cpa.getBean("buildMethodBean");

        System.out.println(JSON.toJSONString(buildMethodBean));
    }
}
