package SimpleFactory.imp;

import SimpleFactory.ICourse;
import SimpleFactory.JavaCourse;

public class JavaCourseFactory implements ICourseFactory{

    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
