package tree;

import java.util.HashMap;

public class Main {
    static HashMap<Integer,Integer> map=new HashMap<>();
    static void init(int[] list){
        for (int i = 0; i < list.length; i++) {
            map.put(list[i],i);
        }
    }
    static int getValue(int key){
        if(map.containsKey(key)){
            return map.get(key);
        }
        return -1;
    }
    public static void main(String[] args) {
        Main.init(new int[]{1,3,4,5,6,9,32,4234,3141});
        System.out.println(Main.getValue(32));
        System.out.println(Main.getValue(333333));
    }
}
