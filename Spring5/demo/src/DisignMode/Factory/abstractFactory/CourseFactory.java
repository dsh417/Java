package DisignMode.Factory.abstractFactory;

public interface CourseFactory {
    INote createNote();
    IVideo createVideo();
}
