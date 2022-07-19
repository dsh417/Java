package DisignMode.Singleton.LazySingleton.head;

import java.io.*;

public class test {
    public static void main(String[] args) {
        System.out.println("\n");
        headerEndSingleton h=headerEndSingleton.getInstance();
        System.out.println(h);
        headerEndSingleton h2=headerEndSingleton.getInstance();
        System.out.println(h2);

//
//        headerEndSingleton h=new headerEndSingleton();
//        System.out.println(h);

        headerEndSingleton s=null;
        try {
            FileOutputStream fos=new FileOutputStream("Sington.obj");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(h);
            oos.flush();


            FileInputStream fis=new FileInputStream("Sington.obj");
            ObjectInputStream ois=new ObjectInputStream(fis);

            s= (headerEndSingleton) ois.readObject();

            System.out.println(s==h);

            System.out.println("序列化无法破坏我的单例");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
