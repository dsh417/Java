package 对象.练习.练习答案;

public abstract class Graphics implements Cloneable,Comparable{

    public abstract Double area();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Graphics){
            Graphics graphics= (Graphics) o;
            
            return this.area().compareTo(graphics.area());
        }
        return 1;
    }
}