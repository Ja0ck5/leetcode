package com.ja0ck5.leetcode;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2 Output: 2 Explanation: There are two ways to climb to the top. 1. 1
 * step + 1 step 2. 2 steps Example 2:
 *
 * Input: 3 Output: 3 Explanation: There are three ways to climb to the top. 1.
 * 1 step + 1 step + 1 step 2. 1 step + 2 steps 3. 2 steps + 1 step
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 11:01 2019/1/2
 * @Modified By:
 */
public class ClimbingStairs {

	public int climbStairs(int n) {
		if (n <= 2) {
			return n;
		} else {
			// 假设从上往下走
			return climbStairs(n - 1) + climbStairs(n - 2);
		}
	}

	public int climbStairs2(int n) {
		if (n <= 1)
			return 1;
		int oneStepRes = 1, twoStepRes = 1, res = 0;
		for (int i = 2; i <= n; i++) {
			res = oneStepRes + twoStepRes;
			twoStepRes = oneStepRes;
			oneStepRes = res;
		}
		return res;
	}

	/**
	 * 动态规划 num ways bottom up
	 * 
	 * @param n
	 * @return
	 */
	public int climbStairs3(int n) {
		if (n <= 1)
			return 1;

		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
}
