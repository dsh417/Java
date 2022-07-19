package DisignMode.Factory.SimpleFactory.imp;

import DisignMode.Factory.SimpleFactory.ICourse;
import DisignMode.Factory.SimpleFactory.PythonCourse;

public class PythonCourseFactory implements ICourseFactory{

    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
