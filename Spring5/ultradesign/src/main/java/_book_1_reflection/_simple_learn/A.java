package _book_1_reflection._simple_learn;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class A {
    int m;
    public A(){
        System.out.println("this is a");
    }
    public A(Integer m){
        System.out.println("this is "+ m);
    }

    public A(String s,Integer m){
        System.out.println(s+" "+ m);
    }
    private void fun1(){
        System.out.println("调用方法1");
    }
    public void fun2(Integer i){
        System.out.println("调用方法2，in："+i);
    }
    public void fun3(String s,Integer i){
        System.out.println(s+i);
    }

    public static void main(String[] args) throws Exception {
//        getClassByReflection();
//        getInstanceByReflection();

//        Class<?> clazz=Class.forName("_book_1_reflection._simple_learn.A");
//        Object o=clazz.getConstructor().newInstance();
//        Method m1=clazz.getMethod("fun1");
//        m1.invoke(o);
//        Method m2=clazz.getMethod("fun2", Integer.class);
//        m2.invoke(o,23);
//        Method m3=clazz.getMethod("fun3", String.class, Integer.class);
//        m3.invoke(o,"213",213);
        Process("_book_1_reflection._simple_learn.A","fun1",new Object[]{});

    }

    static void Process(String className, String funcName, Object[] pare) throws Exception {
        Class<?> classType=Class.forName(className);
//        参数
        Class<?>[] c=new Class[pare.length];
        for (int i = 0; i < pare.length; i++) {
            c[i]=pare[i].getClass();
        }

        Constructor<?> ct=classType.getConstructor();
        Object obj=ct.newInstance();
        Method mt=classType.getDeclaredMethod(funcName,c);
        mt.invoke(obj,pare);
    }

    public static void getInstanceByReflection() throws Exception {
        Class<?> clazz= Class.forName("_book_1_reflection._simple_learn.A");

//        Constructor[] con =clazz.getConstructors();
//        con[0].newInstance();
//        con[1].newInstance(new Object[]{10});
//        con[2].newInstance(new Object[]{"string",2020});

        System.out.println("\n\n\n");
        Constructor c=null;
        c=clazz.getConstructor();
        c.newInstance();
        c=clazz.getConstructor(new Class[]{Integer.class});
        c.newInstance(new Object[]{10});
        c=clazz.getConstructor(new Class[]{String.class,Integer.class});
        c.newInstance(new Object[]{"123",213});
    }

    public static void getClassByReflection() throws ClassNotFoundException {
        //        加载初始化类A,完整包名.类名
        Class<?> classInfo= Class.forName("_book_1_reflection._simple_learn.A");
        System.out.println("反射获取构造函数");
        Constructor[] cons =classInfo.getConstructors();
        for (int i = 0; i < cons.length; i++) {
            System.out.println(cons[i].toString());
        }
        System.out.println("\n获取变量：");
        Field[] fields =classInfo.getDeclaredFields();
        for (int j = 0; j < fields.length; j++) {
            System.out.println(fields[j].toString());
        }
        System.out.println("\n获取方法：");
        Method[] methods =classInfo.getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
        }
    }
}
