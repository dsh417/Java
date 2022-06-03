package 对象.练习.练习答案;

import java.util.Arrays;

public class testGraphics {
    public static void main(String[] args) {
        Circle c1=new Circle(1.0);
        Circle c2=new Circle(2.0);
        Rectangle r1=new Rectangle(1,1);
        Rectangle r2=new Rectangle(2,2);
        Triangle t1=new Triangle(1,1);
        Triangle t2=new Triangle(2,2);

        Graphics[] graphics={c1,c2,t1,t2,r1,r2};

        Arrays.sort(graphics);

        System.out.println(Arrays.toString(graphics));

        for (int i = 0; i < graphics.length; i++) {
            Graphics graphicstemp=graphics[i];
            System.out.println(graphicstemp.area());

        }
    }
}
