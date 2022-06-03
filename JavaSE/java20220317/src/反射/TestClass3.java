package 反射;

import 集合.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

//通过Class访问获得类的信息
public class TestClass3 {
    public static void main(String[] args) throws Exception{
        Class c= Person.class;


//        Scanner sc=new Scanner(System.in);
//
//        Class c=Class.forName(sc.nextLine()     );


        //调用无参构造方法创建对象
        Person p=(Person) c.newInstance();
//        System.out.println(p);


        //调用有参构造方法创造对象
        Constructor constructor=c.getDeclaredConstructor(Integer.class,String.class);
        Person p2= (Person) constructor.newInstance(1,"abc");
//        System.out.println(p2);
//        System.out.println(p2.getId()+" "+p2.getName());

        //访问属性
        Field nameField=c.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(p2,"aaa");
        System.out.println(nameField.get(p2));

        //访问方法
        Method fMethod=c.getDeclaredMethod("f",int.class);
        fMethod.setAccessible(true);
        Object result=fMethod.invoke(p2,2);
        System.out.println(result);

        Method fnMethod=c.getDeclaredMethod("fn");
        fnMethod.invoke(null);


    }
}
