package 接口;

public class C1 implements I1,I2 {
    @Override
    public void f1() {
        System.out.println(1);
    }

    @Override
    public void f2() {
        System.out.println(2);
    }
}
