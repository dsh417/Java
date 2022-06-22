package Template.simple;

public class test {
    public static void main(String[] args) {
        System.out.println("---");
        NetworkcCourse java=new JavaSource();
        java.createCourse();

        System.out.println("---");
        NetworkcCourse bigdata=new BigDataCourse(true);
        bigdata.createCourse();
    }
}
