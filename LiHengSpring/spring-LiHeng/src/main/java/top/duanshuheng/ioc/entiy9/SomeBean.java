package top.duanshuheng.ioc.entiy9;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SomeBean implements ApplicationContextAware {
    private ApplicationContext ac;

    public void doSome(){
        System.out.println("dosome");
//        希望获得ac，在bean里获取容器
        System.out.println("ioc:"+ac);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ac=applicationContext;
    }
}
