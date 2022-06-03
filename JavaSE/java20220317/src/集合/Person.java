package 集合;

import java.util.Objects;

public class Person  implements Comparable<Person>,Cloneable{
    private Integer id;
    private String name;




    public Person(Integer i,String s) throws NullPointerException{
        this.id=i;
        this.name=s;
    }
    public Person() {
    }

    public Person(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    private int f(int i){
        return 1+i;
    }

    public static void fn(){
        System.out.println("null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id) && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public int compareTo(Person o) {
        return this.id-o.id;
    }
}
