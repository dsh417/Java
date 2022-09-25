package old;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class test012 {



    public static void main(String []args){

        //方向：输入、输出
        //类型：字节流、字符流
        //功能：节点流、包装流

        //写流
        //1。选择流
        FileInputStream fis=null;

        FileOutputStream fos=null;

        try {
            //2.创建流
            fis= new FileInputStream("C:/liheng/a.txt");

            fos= new FileOutputStream("C:/liheng/b.txt");
            //3.使用流


            int b;
            while((b=fis.read())!=-1){
                System.out.println(b);
                fos.write(b);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            //4.关闭流
            if(fis!=null){
                try {
                    fis.close();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }

            if(fos!=null){
                try {
                    fos.close();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }

        }
    }


    public void f(){

    }

    public int f(int i){
        return 0;
    }
}
