package Factory.abstractFactory.Java;

import Factory.abstractFactory.CourseFactory;
import Factory.abstractFactory.INote;
import Factory.abstractFactory.IVideo;

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
