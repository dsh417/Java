package Factory.SimpleFactory.imp;

import Factory.SimpleFactory.ICourse;
import Factory.SimpleFactory.PythonCourse;

public class PythonCourseFactory implements ICourseFactory{

    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
