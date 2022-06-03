package LyzySimpleon.test;

import LyzySimpleon.EndLazyInnerClassSingleton;
import LyzySimpleon.SerializableSingleton;

import java.io.*;

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
