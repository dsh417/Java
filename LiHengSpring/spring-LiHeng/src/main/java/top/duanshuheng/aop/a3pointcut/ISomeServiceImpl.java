package top.duanshuheng.aop.a3pointcut;

public class ISomeServiceImpl implements ISomeService{
    @Override
    public void doSome() {
        System.out.println("IsomeService:some");
    }

    @Override
    public void doOther() {
        System.out.println("ISomeSerice:other");
    }
}
