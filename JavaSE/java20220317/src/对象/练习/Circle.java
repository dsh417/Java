package 对象.练习;

public class Circle extends Graphics implements Comparable{

    private double R;
    private final double PI=Math.PI;

    public void setR(double r) {
        R = r;
    }

    public double getR() {
        return R;
    }

    public double getPI() {
        return PI;
    }



    public Circle(double R) {
        super();
        this.R=R;
    }

    public Circle() {
        this(1);
    }
    @Override
    public double area() {
        return PI*R*R;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Graphics){
            Graphics graphics= (Graphics) o;
            if(graphics.area()-((Graphics) o).area()>0){
                return 1;
            }
            if(graphics.area()-((Graphics) o).area()<0){
                return -1;
            }
            return 0;
        }
        return 0;
    }
}
