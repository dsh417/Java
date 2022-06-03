package String;

import java.io.UnsupportedEncodingException;

public class test{
    public static void main(StringShch[] args) throws UnsupportedEncodingException {
        String s="在";

        byte[] b=s.getBytes("utf-8");
        System.out.println(b.length);
        }
}
