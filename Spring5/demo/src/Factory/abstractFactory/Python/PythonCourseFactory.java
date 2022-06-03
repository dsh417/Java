package Factory.abstractFactory.Python;

import Factory.abstractFactory.CourseFactory;
import Factory.abstractFactory.INote;
import Factory.abstractFactory.IVideo;

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
