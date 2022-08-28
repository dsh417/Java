package top.duanshuheng.no1.no1text;

public class ThreadConcurrentExample implements Runnable{
    private static final Long num=100000000L;
    private int sum;

    public ThreadConcurrentExample(int sum) {
        this.sum = sum;
    }

    private static void runWithThread() throws InterruptedException{
        long start=System.currentTimeMillis();

        int tempSum=0;
        ThreadConcurrentExample tec=new ThreadConcurrentExample(tempSum);
        Thread thread=new Thread(tec);
        thread.start();

        int count=0;
        for (int i = 0; i < num; i++) {
            count++;
        }
        thread.join();

        long totalFree=System.currentTimeMillis()-start;
        System.out.println("runWithThread:"+totalFree+",count:"+count);

    }

    private static void runWithSerial() throws InterruptedException {
        long start=System.currentTimeMillis();

        int tempSum=0;
        for (int i = 0; i < num; i++) {
            tempSum+=i;
        }

        int count=0;
        for (int i = 0; i < num; i++) {
            count++;
        }

        long totalFree=System.currentTimeMillis()-start;
        System.out.println("runWithThread:"+totalFree+",count:"+count);
    }
    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            synchronized (this) {
                sum+=i;
            }
        }
    }

    public static void main(String[] args) {
        try {
            runWithThread();
            runWithSerial();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
