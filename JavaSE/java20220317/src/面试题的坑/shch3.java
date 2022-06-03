package 面试题的坑;
//属性没有重写
//父类表super

public class shch3 {
    public static void main(String[] args) {
        E e=new E();
        e.setI(3);
        System.out.println(e.getI());

    }
}

class D{
    public int i=1;

    public void setI(int i) {
        this.i = i;
    }
}
class E extends D{
    private int i=2;

//    @Override
//    public void setI(int i) {
//        this.i = i;
//    }

    public int getI() {
        return super.i;
    }
}