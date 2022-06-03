package JavaSE.Thread;

public class volatileTest {
    public volatile int inc=0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final volatileTest test=new volatileTest();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    test.increase();
                }
            }).start();
        }

        while (Thread.activeCount()>1){
            Thread.yield();
        }
        System.out.println(test.inc);
    }


}
