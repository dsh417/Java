package top.duanshuheng.ioc.Action;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.duanshuheng.ioc.entiy.ListBean;

public class ListBeanText {
    public static void main(String[] args) {

        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");

        ListBean listBean= (ListBean) ac.getBean("listBean");

        System.out.println(JSON.toJSONString(listBean));
    }
}
