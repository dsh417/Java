package 面试题的坑;

public class shch2 {
    public static void main(String[] args) {
        A a=new A();
        f(a);

        B b=new B();
        f(b);

        A ab=new B();
        f(ab);

//        if(ab instanceof A){
//            System.out.println(1);
//        }
    }

    public static void f(A a) {
        System.out.println("AAA");
    }
    public static void f(B a){
        System.out.println("BBB");
    }
}

class A{}

class B extends A{}
