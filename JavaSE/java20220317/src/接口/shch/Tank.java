package 接口.shch;

public class Tank implements Attackable,Movealbe{
    @Override
    public void attack() {
        System.out.println("坦克在攻击");
    }

    @Override
    public void move() {
        System.out.println("坦克在移动");
    }
}
