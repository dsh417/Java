package 接口.shch;

public class Marines implements Attackable,Movealbe{
    public void attack(){
        System.out.println("机枪兵在攻击");
    }

    @Override
    public void move() {
        System.out.println("机枪兵在移动");
    }
}
