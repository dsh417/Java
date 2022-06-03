package day01;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private Boolean sex;
    public Student(){
        super();
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Boolean getSex() {
        return sex;
    }
}
