package 接口.shch;

public class test {
    public static void main(String[] args) {
        Tank t1=new Tank();
        Tank t2=new Tank();
        Marines m1=new Marines();
        Marines m2=new Marines();
        Doctors d1=new Doctors();
        Doctors d2=new Doctors();

        Movealbe[] movealbes={t1,t2,m1,m2,d1,d2};

        for (int i = 0; i < movealbes.length; i++) {
            movealbes[i].move();
            if (movealbes[i] instanceof Attackable) {
                ((Attackable) movealbes[i]).attack();
            }
            if(movealbes[i] instanceof Doctors){
                ((Doctors) movealbes[i]).treatment();
            }
        }
    }
}
