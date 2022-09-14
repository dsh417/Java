package disign.Factory.SimpleFactory.imp;

import disign.Factory.SimpleFactory.ICourse;
import disign.Factory.SimpleFactory.PythonCourse;

public class PythonCourseFactory implements ICourseFactory{

    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
