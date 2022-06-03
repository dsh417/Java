package 接口.shch;

public class Doctors implements Treatable,Movealbe{
    @Override
    public void treatment() {
        System.out.println("护士在治疗");
    }

    @Override
    public void move() {
        System.out.println("护士在移动");
    }
}
