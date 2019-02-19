package com.ja0ck5.dp;

/**
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 14:19 2019/2/19
 * @Modified By:
 */
public class UniquePaths {


    /**
     * f[i][j] = f[i-1][j] + f[i][j-1]
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m,int n){
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i ==0 || j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }


}
