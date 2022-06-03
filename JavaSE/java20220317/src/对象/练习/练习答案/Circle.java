package 对象.练习.练习答案;


public class Circle extends Graphics implements Comparable{

    private Double R;
    private final double PI=Math.PI;



    public Circle(double R) {
        super();
        this.R=R;
    }

    public Circle() {
        this(1);
    }
    @Override
    public Double area() {
        return PI*R*R;
    }


    public void setR(double r) {
        R = r;
    }

    public double getR() {
        return R;
    }

    public double getPI() {
        return PI;
    }
}
