package disign.Decorator.simple;

public class test {

    public static void main(String[] args) {
        Battercake battercake;

        battercake=new BaseBattercake();

        battercake=new EggDecorator(battercake);

        battercake=new SausageDecorator(battercake);

        battercake=new EggDecorator(battercake);

//        和静态代理最大的区别就是，职责不同，静态代理不一定满足is-a关系
//        静态代理会做功能增强，使同一个指责变得不一样

        System.out.println(battercake.getMsg()+"总价"+battercake.getPrice());
    }
}
