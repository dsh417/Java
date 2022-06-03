

import java.util.HashSet;
import java.util.Set;

public class test001 {

    public static void main(String acgz[]){
        String s="AABBBSDAD";
        Set<String> set1=new HashSet<String>();
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String s1=s.substring(i,j+1);
                set1.add(s1);
            }
        }
        System.out.println(set1.size());
    }
}
