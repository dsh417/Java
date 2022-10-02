package nk0928.q2;

import java.util.*;


public class Solution {
    /**
     * 解码
     * @param nums string字符串 数字串
     * @return int整型
     */
    public int solve (String nums) {
        if("0".equals(nums))return 0;
        if("10".equals(nums)||"20".equals(nums))return 1;

        int[] dp=new int[nums.length()+1];
        Arrays.fill(dp,1);

        for (int i = 1; i < nums.length(); i++) {
            if(nums.charAt(i)=='0'){
                if(nums.charAt(i-1)!='1' && nums.charAt(i-1)!='2')return 0;
            }
        }

        for (int i = 2 ; i <=nums.length() ; i++) {
            if(nums.charAt(i-2)=='1'&&nums.charAt(i-1)!='0' || nums.charAt(i-2)=='2'&& nums.charAt(i-1)!='0'&&nums.charAt(i-1)<'7'){
                dp[i]=dp[i-1]+dp[i-2];
            }else {
                dp[i]=dp[i-1];
            }
        }
        return dp[nums.length()];
    }
}