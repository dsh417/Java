package Object.equals;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if(o instanceof Person){
            Person p= (Person) o;
            //少了保护操作
            return this.id.equals(p.id)&&this.name.equals(p.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
    }
}
