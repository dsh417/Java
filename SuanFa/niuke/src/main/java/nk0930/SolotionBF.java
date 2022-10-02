package nk0930;

import java.util.Arrays;
/*
*
step 1：可以用dp[i]dp[i]dp[i]表示要凑出i元钱需要最小的货币数。
step 2：一开始都设置为最大值aim+1aim+1aim+1，因此货币最小1元，即货币数不会超过aimaimaim.
step 3：初始化dp[0]=0dp[0]=0dp[0]=0。
step 4：后续遍历1元到aim元，枚举每种面值的货币都可能组成的情况，取每次的最小值即可，转移方程为dp[i]=min(dp[i],dp[i−arr[j]]+1) dp[i] = min(dp[i], dp[i - arr[j]] + 1)dp[i]=min(dp[i],dp[i−arr[j]]+1).
step 5：最后比较dp[aim]dp[aim]dp[aim]的值是否超过aim，如果超过说明无解，否则返回即可。
*
* */

public class SolotionBF {


    public int minMoney (int[] arr, int aim) {
        if(aim<1)return -1;

//         开数组aim，每种货币都有一个空间，即使浪费了多余的空间
        int[] dp=new int[aim+1];
        Arrays.fill(dp,aim+1);
        dp[0]=0;

//        动态规划
//        i=找的钱
        for (int i = 1; i <= aim; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[j]<=1) {
                    dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                }
            }
        }
        return dp[aim]<aim?-1:dp[aim];
    }
}