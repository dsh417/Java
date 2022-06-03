package 对象.比较;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Student[] students= {
                new Student(6,"aaa",76),
                new Student(4,"bbb",26),
                new Student(2,"ccc",16),
                new Student(1,"ddd",96),
        };

        Arrays.sort(students);
        for (int i = 0; i < students.length; i++) {
            Student student=students[i];
            System.out.println(student.getId());

        }
    }
}
