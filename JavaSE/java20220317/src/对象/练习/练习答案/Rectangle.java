package 对象.练习.练习答案;

public class Rectangle extends Graphics implements Comparable{
    private Double N;
    private Double M;

    public Rectangle(double n, double m) {
        super();
        N = n;
        M = m;
    }

    public Rectangle() {
        this(1,1);
    }

    @Override
    public Double area() {
        return N*M;
    }

    public Double getN() {
        return N;
    }

    public Double getM() {
        return M;
    }

    public void setN(double n) {
        N = n;
    }

    public void setM(double m) {
        M = m;
    }
}
