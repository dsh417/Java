public class Solution {


    /**
     *
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public int minPathSum (int[][] matrix) {
//        填充边界
        int x=matrix.length;
        int y=matrix[0].length;
        int [][] dp=new int[x+1][y+1];
        dp[0][0]=matrix[0][0];
        for (int i = 1; i < x; i++) {
            dp[0][i]=matrix[0][i]+dp[0][i-1];
        }
        for (int i = 1; i < y; i++) {
            dp[i][0]=matrix[i][0]+dp[i-1][0];
        }
//        开始计算
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
//                状态转移方程dp[i][j]=m[i][j]+min(dp[i-1][j],dp[i][j-1]);
                dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[x-1][y-1];

    }
}
