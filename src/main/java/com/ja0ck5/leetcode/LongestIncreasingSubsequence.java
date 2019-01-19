package com.ja0ck5.leetcode;

/**
 *
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18] Output: 4 Explanation: The longest increasing
 * subsequence is [2,3,7,101], therefore the length is 4. Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to
 * return the length. Your algorithm should run in O(n2) complexity. Follow up:
 * Could you improve it to O(n log n) time complexity?
 *
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 10:11 2019/1/18
 * @Modified By:
 */
public class LongestIncreasingSubsequence {

    /**
     * dp O(n^2)
     * @param nums
     * @return
     */
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		// 记录每次的结果
		int[] dp = new int[nums.length];
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
				}
			}
			if (dp[i] > ans) {
				ans = dp[i];
			}
		}
		return ans;
	}

    /**
     *
     * O(nlogn)
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int ans = 0;

        return ans;
    }

}
