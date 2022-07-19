package DisignMode.Factory.abstractFactory.Java;

import DisignMode.Factory.abstractFactory.CourseFactory;
import DisignMode.Factory.abstractFactory.INote;
import DisignMode.Factory.abstractFactory.IVideo;

public class JavaCourseFactory implements CourseFactory {
    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }
}
