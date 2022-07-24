package top.duanshuheng.ioc.entiy11_LastBean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

//所有bean都会执行这两个代码！！！！

public class SomeBeanPropertyPostProcessor implements BeanPostProcessor {
    //    初始化之前

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }


    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //        if("someBean".equals(beanName)){
//
//        }

        if(bean instanceof SomeBean){
            SomeBean someBean= (SomeBean) bean;
            someBean.setStr(someBean.getStr().toUpperCase());
        }

        return bean;
    }


//    初始化之后

}
