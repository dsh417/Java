package top.duanshuheng;

import java.lang.reflect.Proxy;

public class dogProxy implements eat {

    dog dog;

    dogProxy(dog dog){
        this.dog=dog;
    }

    @Override
    public void eat() {
//        System.out.println("狗狗吃东西前得到了加强");
        dog.eat();
    }

}
