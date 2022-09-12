package top.duanshuheng.jdk8.no2synchronized.deadlock.applylocktest;

import java.util.ArrayList;
import java.util.List;

public class ApplyLock {
//    破坏请求保持条件
    private List<Object> list=new ArrayList<>();

    public synchronized boolean applyLock(Resource res1, Resource res2){
//         申请锁
        if(list.contains(res1)||list.contains(res2)){
            return false;
        }else {
            list.add(res1);
            list.add(res2);
            return true;
        }
    }

    public synchronized void free(Resource res1,Resource res2){
//        释放锁
        list.remove(res1);
        list.remove(res2);
    }

}
