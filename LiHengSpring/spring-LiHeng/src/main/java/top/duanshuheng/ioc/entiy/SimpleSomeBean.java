package top.duanshuheng.ioc.entiy;

public class SimpleSomeBean {
    private int var;
    private String str;
    private Class c;

    public void setVar(int var) {
        this.var = var;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void setC(Class c) {
        this.c = c;
    }

    public int getVar() {
        return var;
    }

    public String getStr() {
        return str;
    }

    public Class getC() {
        return c;
    }
}
