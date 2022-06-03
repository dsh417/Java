package 对象.练习;

public class Triangle extends Graphics implements Comparable{
    private double L;
    private double H;

    public Triangle(double l, double h) {
        super();
        L = l;
        H = h;
    }

    public Triangle() {
        this(1,1);
    }

    public double getL() {
        return L;
    }

    public double getH() {
        return H;
    }

    public void setL(double l) {
        L = l;
    }

    public void setH(double h) {
        H = h;
    }



    @Override
    public double area() {
        return L*H*0.5;
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
