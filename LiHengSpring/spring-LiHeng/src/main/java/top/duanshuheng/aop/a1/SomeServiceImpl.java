package top.duanshuheng.aop.a1;

public class SomeServiceImpl implements SomeService{


    @Override
    public void doOther() {
        System.out.println("soOhter");
    }

    @Override
    public void doSome() {
        System.out.println("soSome");
    }

    @Override
    public int fun(int i) {
        System.out.println(i+1);
        return i+1;
    }


}
