package String;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class StringShch {
    public static void main(java.lang.String[] args) {
//        charAt
        java.lang.String s="神里爱我一下十抽出来吧,一定只要十抽哦";
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }
        //      subString字符串不可改变，返回的是新字符串
//            2-lenght
        System.out.println(s.substring(2));
        System.out.println(s.substring(2,4));
        System.out.println(s.substring(2,s.indexOf("十")));
        System.out.println(s.substring(2,s.lastIndexOf("十")));
//        判断前后缀
        java.lang.String s2="name:abc";
        java.lang.String s3="name:abc.txt";
        System.out.println(s2.startsWith("name"));
        System.out.println(s3.endsWith(".txt"));
//      indexOf替代contains
        System.out.println(s.contains("里"));
        System.out.println(s.indexOf("大")!=-1);

//        大小写转换
        System.out.println("---------------------------------");
        System.out.println("abcd".toUpperCase(Locale.ROOT));
        System.out.println("ABCD".toLowerCase(Locale.ROOT));
        System.out.println("abc".equals("ABC"));
        System.out.println("abc".equalsIgnoreCase("ABC"));
        System.out.println("            --123123  1233    ".trim());

        java.lang.String s4="name:但是:dadddddddddddasdax";
//        String s5=s4; 这一步无法测试出长度，因为这时候已经开辟空间了，先截取再赋值
        java.lang.String s5=s4.replace("d","");
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s4.length()-s5.length());
        //        快速找到多少个字符

//        正则表达式只关心字符串格式
        System.out.println("---------------------------------");
//        Scanner sc=new Scanner(System.in);
//        String s6=sc.nextLine();
        java.lang.String s6="a";
        java.lang.String reges="[a-z]";

        System.out.println(s6.toString().matches(reges));
//        java中斜杠有意义，需要输入\需要\\，第一个\是转义，"也是\"

        String p="13599887654";
//        显示前3位后3位
        System.out.println(p.replaceAll("(\\d{3})(\\d{5})(\\d{3})","$1*****$3"));

//        分割
        String s7="13599887654,13593887654,13599887656";
        String[] ss=s7.split(",");
        for (int i = 0; i < ss.length; i++) {
            System.out.println(ss[i].replaceAll("(\\d{3})(\\d{5})(\\d{3})","$1*****$3"));
        }

        char[] a=s7.toCharArray();
        System.out.println(Arrays.toString(a));
    }
}
