package 对象.练习;

public class Rectangle extends Graphics implements Comparable{
    private double N;
    private double M;

    public Rectangle(double n, double m) {
        super();
        N = n;
        M = m;
    }

    public Rectangle() {
        this(1,1);
    }

    @Override
    public double area() {
        return N*M;
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

    public double getN() {
        return N;
    }

    public double getM() {
        return M;
    }

    public void setN(double n) {
        N = n;
    }

    public void setM(double m) {
        M = m;
    }
}
