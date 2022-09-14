package disign.Factory.abstractFactory.Python;

import disign.Factory.abstractFactory.CourseFactory;
import disign.Factory.abstractFactory.INote;
import disign.Factory.abstractFactory.IVideo;

public class PythonCourseFactory implements CourseFactory {
    @Override
    public INote createNote() {
        return new PythonNote();
    }

    @Override
    public IVideo createVideo() {
        return new PythonVideo();
    }
}
