package 对象.比较;

public class Student implements Comparable<Student>{
    private Integer id;
    private  String name;
    private  Integer score;

    public Student(){
        super();
    }

    public Student(Integer i, String aaa, Integer i1) {
        super();
        setId(i);
        setName(aaa);
        setId(i1);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public Integer getScore() {
        return score;
    }

//    @Override
//    public int compareTo(Object o) {
//        if (o instanceof Student) {
//            Student student=(Student) o;
//            return this.id-student.id;
//        }
//
//        return 1;
//    }

    @Override
    public int compareTo(Student o) {
        return this.id-o.id;
    }
}
