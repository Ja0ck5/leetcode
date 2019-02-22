package com.ja0ck5.dp;

/**
 * ump Game
 *
 * * 有n块石头分别在 x 轴的 0，1，......，n-1 位置 * 一只青蛙在石头 0 想跳到石头 n-1 * 如果青蛙在第 i
 * 块石头上，它最多可以向右跳距离 ai * 请问能否跳到石头 n-1 * 例子 input : a=[2,3,1,1,4] output: True *
 * 例子 input: a=[3,2,1,0,4] output: False
 *
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 18:07 2019/2/19
 * @Modified By:
 */
public class JumpGame {

	/**
	 *
	 * @param A
	 * @return
	 */
	public boolean canJump(int[] A) {
		int n = A.length;
		boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            // enumerate the previous stone the frog jumped from
            for (int j = 0; j < i; j++) {
                if(dp[j] && j+ A[j] >=i){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n-1];
	}

}
