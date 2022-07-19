package DisignMode.Factory.SimpleFactory;

public class test {
    public static void main(String[] args) {
//        ICourse iCourse=new JavaCourse();
//        iCourse.record();

//        工厂模式,没有用反射
//        CourseFactory factory=new CourseFactory();
//        factory.create("java").record();

//        工厂模式，使用反射,此时产品丰富不需要修改CourseFactory代码
//          但是方法参数是字符串，可控性需要提升。而且需要强转；
//        CourseFactory factory=new CourseFactory();
//        ICourse iCourse=
//                factory.create("SimpleFactory.JavaCourse");
//        iCourse.record();

//        优化代码
        CourseFactory factory=new CourseFactory();
        ICourse iCourse=factory.create(JavaCourse.class);
        iCourse.record();


    }
}
