//package _book_1_reflection._simple_learn;
//import java.io.*;
//import java.util.Properties;
//
//interface ImsgIn{
//    void process(String s);
//}
//
//class ConsoleMsg implements ImsgIn{
//    public ConsoleMsg() {
//    }
//
//    @Override
//    public void process(String s) {
//        System.out.println(s);
//    }
//}
//
//public class IMsg {
//    public static void main(String[] args) throws Exception{
//        Properties p=new Properties();
//        p.load(new FilterInputStream("msg.properties"));
//        String cname=p.getProperty("class");
//        ImsgIn o=null;
//        o= (ImsgIn) Class.forName(cname).getConstructor().newInstance();
//        o.process("sasd");
//
//    }
//}
