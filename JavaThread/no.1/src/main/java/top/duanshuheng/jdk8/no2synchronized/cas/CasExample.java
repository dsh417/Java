package top.duanshuheng.jdk8.no2synchronized.cas;

public class CasExample {
    public volatile int i;
    public synchronized void incr(){
        i++;
    }
//    ↑加锁性能问题
//    ↓无锁设计（CAS基本原理）(基于乐观锁)
    public void incr(int expect){
        if (i == expect) {
            i++;
        }
    }
//    CAS实现：
    public void incr(int V,int E,int U){
        if(V==E){
//            更新变量值
        }else {
//            不更新变量值
        }
    }
//    Unsafe类提供CAS方法（如果内部）
    public final native boolean compareAndSwapInt(Object o,long offset,int expect,int update);
    /*
    * o         目标对象
    * offset    内存地址偏移量
    * expect    比较的期望值
    * update    要更新的值
    *
    * */
}
