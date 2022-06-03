package 内部类;

public class TestInnerClass1 {
    public static void main(String[] args) {
//        OuterA.i
//        OuterA.fun();
        OuterA.InnerA innerA=new OuterA.InnerA();
        innerA.f();


        OuterA outerA=new OuterA();
        OuterA.InnerB innerB=outerA.new InnerB();
        innerB.f();
    }

}

class OuterA{
    private static int i=1;
    private int j=2;

//    静态内部类 public可以访问，private封装外部不可访问
    public static class InnerA{
        public void f(){
            System.out.println(i);
//            System.out.println(j); 静态的不能访问成员

        }

    }

//    成员内部类
    public class InnerB{
        private int j=3;
        public void f(){
            System.out.println(i);
            System.out.println(j);
            System.out.println(OuterA.this.j);
//            访问外部类同名属性语法
        }
}



    public static void fun() {
        InnerA innerA=new InnerA();
        innerA.f();
    }

    public void fun2(){
        InnerB innerB=new InnerB();
        innerB.f();
    }
}
