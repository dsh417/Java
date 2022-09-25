package aop2;

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
