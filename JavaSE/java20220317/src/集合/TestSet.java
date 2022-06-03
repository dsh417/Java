package 集合;

import java.util.*;

/*
* Set使用Map实现，使用了Map的key（适配器模式）
* HashSet       底层哈希散列表             找东西快【推荐】
* TreeSet       底层是平衡二叉树           有自然顺序（小的放左边，大的右边）
* LinkedHashSet 底层是哈希散列表和链表      找东西快，而且有放入顺序
* */

public class TestSet{
    public static void main(String[] args) {
//        Set<String> s=new HashSet<>();
//
//        s.add("aaa");
//        s.add("bbb");
//        s.add("dsd");
//        s.add("bsadabb");
//        s.add("aadsaaa");
//        s.add("aaa");

        Set<Person> s=new LinkedHashSet<Person>();

        s.add(new Person(6,"aaa"));
        s.add(new Person(2,"ggg"));
        s.add(new Person(3,"adfaa"));
        s.add(new Person(4,"adaa"));

        for (Person p :
                s) {
            System.out.println(p.getId()+""+p.getName());
        }















//        Set<Person> person=new HashSet<Person>();
//
//        Person p1=new Person(1,"aaa");
//
//        person.add(p1);
//        person.add(p1);
//        System.out.println(person.size());
//
//        Person p2=new Person(2,"bbb");
//
//        person.add(p2);
//        System.out.println(person.size());
//
//
//        Person p3=new Person(2,"bbb");
//        person.add(p3);
//        System.out.println(person.size());











//        System.out.println(s);
//
//        System.out.println(s.size());

//        //获得迭代器
//        Iterator<String> it=s.iterator();
//
//        while (it.hasNext()){
//            String str=it.next();
//            System.out.println(str);
//        }
//        JDK5.0之后提供foreach语句，底层和上面迭代器完全一样

//        for(String str:s){
//            System.out.println(str);
//        }
        //----------------------------------------------
        //如果s中有aaa元素打印并删除（）

//        for(String str:s){
//            if("aaa".equals(str)){
//                System.out.println(str);
//
//
//                s.remove(str);
//            }
//        }





//        Iterator<String> it=s.iterator();
//
//        while(it.hasNext()){
//            String str=it.next();
//            if("aaa".equals(str)){
//                System.out.println(str);
////                s.remove(str);
////                作删除只能用迭代器remove方法，foreach无法
//                it.remove();
//            }
//        }
//        System.out.println(s);


//
//        s.remove("aaa");
//        System.out.println(s);


        //出入
//        Iterator<String> it=s.iterator();
//
//        while(it.hasNext()){
//            String str=it.next();
//            System.out.println(str);
//        }
//
//        it=s.iterator();
//
//        while(it.hasNext()){
//            String str=it.next();
//            System.out.println(str);
//        }



//        String[] ss={"aaa","bbb","vvv"};

//        for (String string :
//                ss) {
//            string=string.toUpperCase();
//        }


//        System.out.println(Arrays.toString(ss));
    }
}
