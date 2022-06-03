package 集合;

import 集合.练习.MyArrayList;

import java.util.LinkedList;
import java.util.List;



/*
* ArrayList 底层数组【推荐】     线程不安全 适合查询多的操作（代替数组）
* Vector    底层数组            线程安全
* LinkedList双向链表
* */
public class TestList {
    public static void main(String[] args) {
        MyArrayList l=new MyArrayList();

        StringBuffer sb=new StringBuffer();

        for (int i = 64; i < 100; i++) {
            char temp=(char)i;
            sb.append(temp);
            l.add(sb.toString());
            sb.delete(0,sb.length());
        }

        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }
}
