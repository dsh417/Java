package 反射;

import java.lang.reflect.Array;

public class TestClass4 {
    public static void main(String[] args) {
//        String[] arr=new String[4];

        Object arr= Array.newInstance(String.class,4);

        System.out.println(arr);

        //arr[0]="abc"
        Array.set(arr,0,"abc");

        //sout(arr[0])
        System.out.println(Array.get(arr,0));


    }
}
