package disign.Proxy.StaticProxy.simple;

public class test {
    public static void main(String[] args) {
        Father f=new Father(new Son());
        //只能帮儿子找对象，不能帮陌生人
        f.findLove();
    }
}
