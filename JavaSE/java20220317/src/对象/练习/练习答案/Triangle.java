package 对象.练习.练习答案;

public class Triangle extends Graphics implements Comparable{
    private Double L;
    private Double H;

    public Triangle(double l, double h) {
        super();
        L = l;
        H = h;
    }

    public Triangle() {
        this(1,1);
    }

    public Double getL() {
        return L;
    }

    public Double getH() {
        return H;
    }

    public void setL(double l) {
        L = l;
    }

    public void setH(double h) {
        H = h;
    }



    @Override
    public Double area() {
        return L*H*0.5;
    }

}
