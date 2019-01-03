package com.ja0ck5.leetcode;

/**
 *
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6 Explanation: [4,-1,2,1] has the
 * largest sum = 6. Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 17:56 2019/1/2
 * @Modified By:
 */
public class MaximumSubarray {

	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum > max) {
				max = sum;
			}
			if (sum < 0) {
				sum = 0;
			}
		}
		return max;
	}

	public int maxSubArray2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
		    // 任何一个数加上负数,肯定比原来的数小,所以可以遗弃掉
			dp[i] = nums[i] + (dp[i - 1] < 0 ? 0 : dp[i - 1]);
			res = Math.max(res, dp[i]);
		}

		return res;
	}

	// TODO If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

}
