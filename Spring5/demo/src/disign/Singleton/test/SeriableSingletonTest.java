package disign.Singleton.test;

import disign.Singleton.RegisteredSingleton.EnumSington;
import disign.Singleton.LazySingleton.SerializableSingleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SeriableSingletonTest {
    public static void main(String[] args) {
        SerializableSingleton s1=null;
        SerializableSingleton s2= SerializableSingleton.getInstance();
//        EndLazyInnerClassSingleton s2= EndLazyInnerClassSingleton.getInstance();


        FileOutputStream fos=null;

        try {
            fos=new FileOutputStream("SeriableSingleton.obj");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            FileInputStream fis=new FileInputStream("SeriableSingleton.obj");
            ObjectInputStream ois=new ObjectInputStream(fis);
            s1=(SerializableSingleton) ois.readObject();
            ois.close();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1==s2);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class SeriableSingletonInnerClassTest1{
    public static void main(String[] args) {
        try {
            Class clazz= EnumSington.class;
            Constructor c=clazz.getDeclaredConstructor();
            c.newInstance();
            //java.lang.NoSuchMethodException: EnumSingleton.EnumSington.<init>() :没有找到无参构造方法

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class SeriableSingletonInnerClassTest2{
    public static void main(String[] args) {
        try {
//           查看Enum源码构造方法，只有一个protected
//                protected Enum(String name, int ordinal) {
//                this.name = name;
//                this.ordinal = ordinal;
//            }
            Class clazz= EnumSington.class;
            Constructor c=clazz.getDeclaredConstructor(String.class,int.class);
            c.setAccessible(true);
            Object o=c.newInstance("tom",666);

//            Exception in thread "main" java.lang.IllegalArgumentException: Cannot reflectively create enum objects
//            无法反射创建的枚举对象
//            Constructor的newInstance源码中：
//        if ((clazz.getModifiers() & Modifier.ENUM) != 0)
//            throw new IllegalArgumentException("Cannot reflectively create enum objects");
//            如果类修饰符是Modifier.ENUM枚举类型,直接抛出异常
//              结论:
//            枚举式单例是effective java推荐的单例写法，jdk 枚举的语法 及 反射的newInstance 也为枚举保驾护航
//            枚举单例成为比较优雅的实现
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
