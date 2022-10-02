package bd09272;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static int result=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in    );
        int maxNum=Integer.parseInt(sc.nextLine().split(" ")[0]);
        for (int i = 0; i < maxNum; i++) {
            String[] s=sc.nextLine().split(" ");
            int [] is=new int[s.length];
//            int index1=-1;
            for (int j = 0; j < s.length; j++) {
                is[j]=Integer.parseInt(s[j]);
//                if(is[j]==1)index1=j;
            }
            HashSet<Integer> set=new HashSet<>();
            for (int index = 0; index < is.length; index++) {
                set.add(is[0]);
                boolean temp=true;

                for (int k=1;k<index+1;k++) {
                    for (int j = k; j < index+1; j++) {
                        if(!set.contains(j)){
                            temp=false;
                            break;
                        }
                    }
                    if(temp){
                        result++;
                    }
                }
            }
            System.out.println(result);
            result=0;
        }
    }
}
