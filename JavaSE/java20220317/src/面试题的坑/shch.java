package 面试题的坑;

public class shch {
    public static void main(String[] args) {
        C[] cs=new C[3];

//        C c=null;

//        C c=new C();

        for (int i = 0; i < cs.length; i++) {

//            c.setName("c"+i);
//            cs[i]=c;

//            cs[i]=new C();
//            cs[i].setName("c"+i);

            C c=new C();
            c.setName("c"+i);
            cs[i]=c;
        }

        for (int i = 0; i < cs.length; i++) {
            System.out.println(cs[i].getName());
        }
    }
}
class C{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
