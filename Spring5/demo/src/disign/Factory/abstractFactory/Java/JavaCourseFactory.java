package disign.Factory.abstractFactory.Java;

import disign.Factory.abstractFactory.CourseFactory;
import disign.Factory.abstractFactory.INote;
import disign.Factory.abstractFactory.IVideo;

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
