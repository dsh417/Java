package old;

import java.util.*;
//全排列
public class test008 {
    public static void main(String args[]){
        String str="ABC";
        HashSet<String> hash=new HashSet<String>();
        fun(hash,0,str.length()-1,str.toCharArray());
        System.out.print(hash.size());
    }

    public static void fun(HashSet hash,int form,int to,char[] arr){
        if(form==to){
            hash.add(new String(arr));
        }else{
            for(int i=form;i<=to;i++){
                swap(arr,i,form);
                fun(hash,form+1,to,arr);
                swap(arr,form,i);
            }
        }
    }

    public static void swap(char[] arr,int n ,int m){
        char temp;
        temp=arr[n];
        arr[n]=arr[m];
        arr[m]=temp;
    }
}
