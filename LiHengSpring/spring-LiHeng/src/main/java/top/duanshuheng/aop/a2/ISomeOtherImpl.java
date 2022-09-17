package top.duanshuheng.aop.a2;

public class ISomeOtherImpl implements IOtherService{
    @Override
    public void doSome() {
        System.out.println("other:some");
    }
}
