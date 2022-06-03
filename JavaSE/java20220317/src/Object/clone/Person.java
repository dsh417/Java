package Object.clone;

public class Person implements Cloneable {
    private String id;
    private String name;
    private Address address;

    public Person(){
        super();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
