package 对象.练习;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        Graphics[] graphics={
                new Circle(1),
                new Circle(2),
                new Rectangle(1,1),
                new Rectangle(2,2),
                new Triangle(1,1),
                new Triangle(2,2)
        };

        Arrays.sort(graphics);

        for (int i = 0; i < graphics.length; i++) {
            Graphics temp=graphics[i];
            System.out.println(temp.area());
        }


    }
}
