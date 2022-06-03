package 多态;

public class Person {
    private String name;
    private Transport transport;

    public Person(String s){
        this.name=s;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public void move(){
        System.out.println(getName()+"在走路");
    }
    public void move(Transport transport){
        System.out.print(getName()+"乘坐");
        transport.move();
    }


}
