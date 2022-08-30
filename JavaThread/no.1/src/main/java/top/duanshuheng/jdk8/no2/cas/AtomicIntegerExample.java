package top.duanshuheng.jdk8.no2.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    public AtomicInteger atomicInteger=new AtomicInteger(0);

    public void add(){
        atomicInteger.getAndIncrement();

//        while：如果执行失败就是被其他线程抢占，但是这里是原子操作，所以必须要成功
//        public final int getAndAddInt(Object o, long offset, int delta) {
//            int v;
//            do {
//                v = getIntVolatile(o, offset);
//            } while (!weakCompareAndSetInt(o, offset, v, v + delta));
//            return v;
//        }
    }
}
