package 多态;

public class Plain extends Transport{
    Plain(String s){
        super(s);
    }

    @Override
    public void move() {
        System.out.println(getName()+"在飞");
    }

}
