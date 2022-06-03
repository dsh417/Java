package 多态;

public class Train extends Transport{

    Train(String s){
        super(s);
    }

    @Override
    public void move() {
        System.out.println(getName()+"在行驶");
    }

}
