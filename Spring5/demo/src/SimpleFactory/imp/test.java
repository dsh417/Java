package SimpleFactory.imp;

import SimpleFactory.ICourse;

public class test {
    public static void main(String[] args) {
        ICourseFactory factory1=new PythonCourseFactory();
        ICourse course1=factory1.create();
        course1.record();

        ICourseFactory factory2=new JavaCourseFactory();
        ICourse course2=factory2.create();
        course2.record();


    }
}
