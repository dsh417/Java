package top.duanshuheng.aop2.aop6;

public class SomeServiceImpl implements ISomeService{
    @Override
    public void doSome() {
        System.out.println("SomeServiceImpl.some");
    }

    @Override
    public void doOther() {
        System.out.println("SomeServiceImpl.ohter");
    }
}
