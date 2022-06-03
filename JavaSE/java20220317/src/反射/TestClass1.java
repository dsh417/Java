package 反射;

import 集合.Person;

import java.util.Scanner;


//获得Class对象
public class TestClass1 {
    public static void main(String[] args) throws Exception{
        //1,通过对象获得Class对象
        Person p=new Person();
        Class c1=p.getClass();

        //2，通过类获得Class对象
        Class c2=Person.class;

        //3，通过字符串获得Class对象

        Class c3=Class.forName("集合.Person");


        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

//        System.out.println(c1==c2);
//
//        System.out.println(int.class);

        Scanner sc=new Scanner(System.in);
        String className=sc.nextLine();

        System.out.println(Class.forName(className));
    }
}
