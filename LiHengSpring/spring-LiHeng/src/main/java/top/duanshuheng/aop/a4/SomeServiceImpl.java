package top.duanshuheng.aop.a4;


public class SomeServiceImpl implements ISomeService {
    @Override
    public void doSome() {
        System.out.println("SomeService:doSome");
    }

    @Override
    public void doOther() {
        System.out.println("SomeService:doOther");

    }
}
