package disign.Prototype.ShallowClones.imp;

import disign.Prototype.ShallowClones.Prototype;

import java.util.List;

public class ConcretePrototypeA implements Prototype {
    private int age;
    private String name;
    private List hobbies;

    public ConcretePrototypeA() {
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHobbies(List hobbies) {
        this.hobbies = hobbies;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List getHobbies() {
        return hobbies;
    }

    @Override
    public Prototype clone() {
        ConcretePrototypeA concretePrototypeA=new ConcretePrototypeA();
        concretePrototypeA.setAge(this.age);
        concretePrototypeA.setHobbies(this.hobbies);
        concretePrototypeA.setName(this.name);

        return concretePrototypeA;

    }
}
