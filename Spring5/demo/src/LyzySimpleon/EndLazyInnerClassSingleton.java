package LyzySimpleon;

//【完结】自认为史上最牛的单例模式的实现方式,运行成功!2022年6月2日18:45:08
//解决 反射/序列化 破坏单例
//缺陷 没有从根本解决序列化创建新对象的问题->转到注册式单例模式 EnumSingleton 包中

import java.io.Serial;
import java.io.Serializable;

public class EndLazyInnerClassSingleton implements Serializable {
    //解决饿懒汉单例模式内存浪费和synchronized性能问题
    //使用EndLazyInnerClassSingleton的时候，默认会初始化内部类
    //如果没使用，内部类是不加载的
    //心得：
    //寻常调用该对象的getInstance方法，先加载外部类对象调用其构造方法，再在使用内部类时加载内部类，内部类在常量池实例化外部类对象，然后再返回该对象
    //反射暴力获取外部类构造方法，然后getInstance，

    private EndLazyInnerClassSingleton(){
        System.out.println("调用外部类构造方法 "+this.getClass());
        if(LazyHolder.LAZY != null){
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    //每一个关键字都不多余，static使单例空间共享，保证这个方法不会被重写、重载
    public final static EndLazyInnerClassSingleton getInstance(){
        //返回结果以前一定会先加载内部类
        System.out.println("调用getInstance方法 ");
        return LazyHolder.LAZY;
    }

    //默认不加载
    private static class LazyHolder{
        private static final EndLazyInnerClassSingleton LAZY=new EndLazyInnerClassSingleton();
        static {
            System.out.println("加载静态内部类");
        }
    }

    //优化序列化破坏单例,然而通过翻源码，实际上可以知道实例化了两次，只不过新的对象没有被返回，并没有从根本解决问题
    @Serial
    private Object readResolve(){
        return LazyHolder.LAZY;
    }
}
