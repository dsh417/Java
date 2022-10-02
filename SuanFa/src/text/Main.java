package text;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Main main=new Main();
        System.out.println(Arrays.toString(main.FindNumsAppearOnce(new int[]{1, 2, 3, 4, 1, 2})));

    }

    public Main() {
    }

    public int[] FindNumsAppearOnce (int[] array) {
        HashMap<Integer,Integer> map=new HashMap<>();
        HashMap<Integer,Integer> resultMap=new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if(map.containsKey(array[i])){
                map.put(array[i],map.get(array[i])+1);
                resultMap.remove(array[i]);
            }else {
                map.put(array[i],1);
                resultMap.put(array[i],1);
            }
        }
        if (!resultMap.isEmpty()){
            int[] aa=new int[2];
            aa[0]=0;
            aa[1]=1;
            for (Map.Entry<Integer, Integer> entry: resultMap.entrySet()){
                if(aa[0]==0){
                    aa[0]=entry.getKey();

                }else {
                    aa[1]=entry.getKey();
                }
            }
            return aa;
        }
        return null;
    }

    public int uniquePaths (int m, int n) {
        int[][] num=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(j==0 || i==0){
                    num [i][j]=1;
                    continue;
                }
//
                num[i][j]=num[i-1][j]+num[i][j-1];
            }
        }
        return num[m-1][n-1];

    }

    public String LCS (String str1, String str2) {
        int len=0;
        int maxIndex=0;
        int[][] num=new int[str1.length()+1][str2.length()+1];

        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
//                dp[i][j]=dp[i-1][j-1]+1
                if(str1.charAt(i)==str2.charAt(j)){
//                    字符串相等记录到下一个dp
                    num[i+1][j+1] = num[i][j]+1;
                    if (num[i+1][j+1]>len) {
                        maxIndex=i;
                        len=num[i+1][j+1];
                    }
                }else {
                    num[i][j]=0;
                }
            }
        }
        return str2.substring(maxIndex+1-len,maxIndex+1);
    }
}