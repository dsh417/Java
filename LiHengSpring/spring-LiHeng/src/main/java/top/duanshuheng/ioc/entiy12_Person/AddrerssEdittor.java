package top.duanshuheng.ioc.entiy12_Person;

import java.beans.PropertyEditorSupport;

public class AddrerssEdittor extends PropertyEditorSupport {


//    转换重写的方法，继承propertyEditorSupport

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Address2 addr=new Address2();
        String[] s=text.split("-");
        addr.setProvince(s[0]);
        addr.setSome(s[1]);

        //把对象放进去。有set，就有getvalue
        setValue(addr);
    }


//    public void setAsText(String text){
//        Address2 addr=new Address2();
//        String[] s=text.split("-");
//        addr.setProvince(s[0]);
//        addr.setSome(s[1]);
//
//        //把对象放进去。有set，就有getvalue
//        setValue(addr);
//    }
//    现在关心什么时候转换-》后处理bean（spring写好了，只需要我们配置
//    BeanFactoryPostProcessor

}
