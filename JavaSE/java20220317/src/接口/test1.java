package 接口;

public class test1 {
    public static void main(String[] args) {
        I1 i1=new C1();
        i1.f1();

        if(i1 instanceof I2){
            ((I2)i1).f2();
        }

        I3 i3=new C2();
        i3.f3();
    }
}
