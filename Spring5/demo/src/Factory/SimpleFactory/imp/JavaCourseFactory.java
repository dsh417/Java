package Factory.SimpleFactory.imp;

import Factory.SimpleFactory.ICourse;
import Factory.SimpleFactory.JavaCourse;

public class JavaCourseFactory implements ICourseFactory{

    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
