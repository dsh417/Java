package 多态;

/*
*
* 多态
*
* 对象多态：
*   把一种类型用他自己或者他自己的父类型来引用
*   instanceof
* 方法多态：
*   重载；
*   重写：继承的情况下，
*       子类方法名和父类方法名相同、参数相同、返回类型相同、
*       访问权限不能更小，private最小，public最大
*       抛出的异常不能更大
*   调用的是子类的方法，要使用父类方法需要转换，
*   java提供转换类型保护关键字instanceof
* */

public class instance {
    public static void main(String[] args) {
        Person person=new Person("橙子狗");
        person.move();

        Train train=new Train("复兴号");
        person.move(train);

        Plain plai=new Plain("东方航空");
        person.move(plai);
    }
}
