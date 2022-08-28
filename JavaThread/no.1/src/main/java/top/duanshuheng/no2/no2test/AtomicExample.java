package top.duanshuheng.no2.no2test;

public class AtomicExample {
    volatile int i=0;
    public void add(){
        i++;
    }

    public static void main(String[] args) {
        try {
            AtomicExample atomicExample=new AtomicExample();
            Thread[] threads=new Thread[2];

            for (int k = 0; k < 2; k++) {
                threads[k]=new Thread(
                        ()->{
                            for (int w = 0; w < 10000; w++) {
                                atomicExample.add();
                            }
                        }
                );
                threads[k].start();
            }
            threads[0].join();
            threads[1].join();
            System.out.println(atomicExample.i);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
