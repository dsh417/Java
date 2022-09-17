package top.duanshuheng.aop.a2;

public class ISomeServiceImpl implements ISomeService{
    @Override
    public void doSome() {
        System.out.println("service:some");
    }

    @Override
    public void doOther() {

        System.out.println("service:other");
    }
}
