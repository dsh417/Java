package Factory.abstractFactory;

import Factory.abstractFactory.Java.JavaCourseFactory;

public class test {
    public static void main(String[] args) {
        JavaCourseFactory factory=new JavaCourseFactory();
        factory.createNote().edit();
        factory.createVideo().record();
    }
}
