package 内部类;

public class TestInnerClass2 {
    public static void main(String[] args) {
        OuterB outerB=new OuterB();
        MyInterface myInterface=outerB.f1(2);
//        -------------------------------------------
        myInterface.innerF();


//        f4：模板模式,为了开发简单（方便而用）
        outerB.f4(new MyInterface() {
            @Override
            public void innerF() {
                System.out.println("11111111");
                System.out.println("22222222");
                System.out.println("33333333");
            }
        });

        outerB.f4(new MyInterface() {
            @Override
            public void innerF() {
                System.out.println("4444444");
            }
        });
    }

}

interface MyInterface{
    public void innerF();

}
class OuterB{
    private int i=1;

    public MyInterface f1(final int j){
        final int k=3;
//      局部内部类
        class InnerC implements MyInterface{
            public void innerF(){
                System.out.println(i);
                System.out.println(j);
                System.out.println(k);
            }
        }

        InnerC innerC=new InnerC();
//        innerC.innerF();
        return innerC;
    }

//    public void f1(final int j){
//        final int k=3;
////      局部内部类
//        class InnerC{
//            public void innerF(){
//                System.out.println(i);
//                System.out.println(j);
//                System.out.println(k);
//            }
//        }
//
//        InnerC innerC=new InnerC();
//        innerC.innerF();
//    }


    public MyInterface f2(){
//        匿名内部类,替代以下f3和myclass
        final int j=2;
        return new MyInterface() {
            @Override
            public void innerF() {
                System.out.println(j);
            }
        };
    }

    public MyInterface f3(){
            return new Myclass();
    }

    class Myclass implements MyInterface{
        @Override
        public void innerF() {

        }
    }


    public void f4(MyInterface inter){

        System.out.println("aaaa");

        inter.innerF();


        System.out.println("bbbb");

    }

}
