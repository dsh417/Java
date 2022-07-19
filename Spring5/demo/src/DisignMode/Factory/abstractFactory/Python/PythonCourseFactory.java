package DisignMode.Factory.abstractFactory.Python;

import DisignMode.Factory.abstractFactory.CourseFactory;
import DisignMode.Factory.abstractFactory.INote;
import DisignMode.Factory.abstractFactory.IVideo;

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
