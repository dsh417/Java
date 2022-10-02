package bd0927;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] s0=sc.nextLine().split(" ");
        int num=Integer.parseInt(s0[0]);
        int row=Integer.parseInt(s0[0]);
        if(row==0){
            System.out.println(0.0d);
        }
        String[] s=sc.nextLine().split(" ");
        List<Integer> list=new ArrayList<>();
        for (String value : s) {
            list.add(Integer.parseInt(value));
        }
        list.sort((x,y)->x-y);
        System.out.println();
    }
}
