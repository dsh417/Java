package SimpleFactory.imp;

import SimpleFactory.ICourse;
import SimpleFactory.PythonCourse;

public class PythonCourseFactory implements ICourseFactory{

    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
