package 集合;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
* HashMap           key为哈希散列表，线程不安全，允许有一个key为null，value可以为null
* Hashtable         key为哈希散列表，线程安全，key和value都不能为null
* TreeMap           key为平衡二叉树
* LinkedHashMap     kery为哈希散列表和链表
* Properties        访问属性文件，特殊的Map，Key和Value都是String类型
* */
public class TestMap {
    public static void main(String[] args) {
        Map<String,Integer> m=new HashMap<String,Integer>();

        m.put("a",1);
        m.put("b",2);
        m.put("c",3);
        m.put("d",4);



//        使用KeySet遍历Map，获得Map所有Key
        Set<String> keys= m.keySet();
        for (String key :
                keys) {
            System.out.println(key+"="+m.get(key));
        }

//        使用entrySet遍历Map，获得Map所有Entry
        Set<Map.Entry<String,Integer>> entrys=m.entrySet();
        for (Map.Entry<String, Integer> entry :
                entrys) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }


//        System.out.println(m.get("b"));


    }

}
