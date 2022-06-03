package 多态;

public class Transport {
    private String name;


    public Transport(String s){
        this.setName(s);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void move(){
        System.out.println(getName()+"在移动");
    }

}
