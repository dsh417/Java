package DisignMode.Factory.SimpleFactory;

public class CourseFactory {
//    public ICourse create(String name){
////        增加课程要再修改工厂，不符合开闭原则
////        if ("java".equals(name)){
////            return new JavaCourse();
////        }else if ("python".equals(name)){
////            return new PythonCourse();
////        }else {
////            return null;
////        }
//
////        工厂模式，使用反射,此时产品丰富不需要修改CourseFactory代码
////          但是方法参数是字符串，可控性需要提升。而且需要强转；
//        try{
//            if(!((null==name)||"".equals(name))){
//                return (ICourse) Class.forName(name).newInstance();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//
//    }
    public ICourse create(Class<? extends ICourse> clazz){
        try{
            if(null!=clazz){
                return clazz.newInstance();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
