package EnumSingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class EnumSingletonTest {
    public static void main(String[] args) {
        //通过反射
        try {
            Class clazz=EnumSington.class;
            Constructor c=clazz.getDeclaredConstructor();

            c.newInstance();

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

    //枚举类在静态代码块中给INSTANCE就赋值，属于饿汉式单例模式。
//    public static void main(String[] args) {
//        try {
//            EnumSington instance1=null;
//
//            EnumSington instance2=EnumSington.getInstance();
//            instance2.setData(new Object());
//
//            FileOutputStream fos=new FileOutputStream("EnumSingleton.obj");
//            ObjectOutputStream oos=new ObjectOutputStream(fos);
//            oos.writeObject(instance2);
//            oos.flush();
//            oos.close();
//
//            FileInputStream fis=new FileInputStream("EnumSingleton.obj");
//            ObjectInputStream ois=new ObjectInputStream(fis);
//            instance1=(EnumSington) ois.readObject();
//            ois.close();
//
//            System.out.println(instance1.getData());
//            System.out.println(instance2.getData());
//            System.out.println(instance1.getData()==instance2.getData());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
}
