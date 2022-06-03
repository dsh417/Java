package 多态;

public class Baby extends Person{


    public Baby(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println(getName()+"在爬");
    }


}
