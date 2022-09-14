package disign.Factory.SimpleFactory.imp;

import disign.Factory.SimpleFactory.ICourse;
import disign.Factory.SimpleFactory.JavaCourse;

public class JavaCourseFactory implements ICourseFactory{

    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
