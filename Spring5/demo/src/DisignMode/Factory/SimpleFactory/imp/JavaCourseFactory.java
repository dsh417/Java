package DisignMode.Factory.SimpleFactory.imp;

import DisignMode.Factory.SimpleFactory.ICourse;
import DisignMode.Factory.SimpleFactory.JavaCourse;

public class JavaCourseFactory implements ICourseFactory{

    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
