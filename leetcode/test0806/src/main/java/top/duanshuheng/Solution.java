package top.duanshuheng;

import java.util.*;


class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer,Integer> map=new HashMap<>();

        long day=(long)tasks[0];
        map.put(tasks[0],0);

        for (int i = 1; i < tasks.length; i++) {
            if(map.containsKey(tasks[i])){
                if(i-map.get(tasks[i])>space){
                    day=(long) (day+tasks[i]);
                }else {
                    day=(long) (day+tasks[i]+(i-map.get(i)));
                }
                map.put(tasks[i],i);
            }else {
                day=(long) (day+tasks[i]);
                map.put(tasks[i],i);
            }
        }
        return day;
    }
}