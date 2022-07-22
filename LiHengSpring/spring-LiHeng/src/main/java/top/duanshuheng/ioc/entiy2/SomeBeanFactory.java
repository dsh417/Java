package top.duanshuheng.ioc.entiy2;

public class SomeBeanFactory {

    public static ISomeBean getiSomeBean() {
        return new SomeBean();
    }
}
