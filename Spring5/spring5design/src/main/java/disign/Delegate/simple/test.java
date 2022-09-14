package disign.Delegate.simple;

public class test {
    public static void main(String[] args) {
        new Boss().command("登录",new Leader());
        /*
        * 委派模式注重结果
        * 策略模式注重可扩展性（外部可扩展性），委派模式注重内部的灵活性和复用性
        * 委派模式的核心就是分发，调度，派遣。委派模式是静态代理和策略模式的一种特殊组合
        * */
    }
}
