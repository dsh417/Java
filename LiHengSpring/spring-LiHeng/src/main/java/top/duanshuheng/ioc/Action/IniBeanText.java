package top.duanshuheng.ioc.Action;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.duanshuheng.ioc.entiy.IniBean;

public class IniBeanText {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");


        IniBean iniBean= (IniBean) ac.getBean("iniBean");


        System.out.println(JSON.toJSONString(iniBean));

//        ac.destroy();弃用，线程不安全
        ac.registerShutdownHook();
    }
}
