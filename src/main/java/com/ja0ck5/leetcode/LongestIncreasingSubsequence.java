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
	 * 
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
	 * 
	 * @param nums
	 * @return
	 */
	public int lengthOfLIS2(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] minLast = new int[nums.length + 1];
		minLast[0] = Integer.MIN_VALUE;
		for (int i = 1; i <= nums.length; i++) {
			minLast[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < nums.length; i++) {
			// find the first number in minLast >= nums[i]
			int index = binarySearch(minLast, nums[i]);
			minLast[index] = nums[i];
		}

		for (int i = nums.length; i >= 1; i--) {
			if (minLast[i] != Integer.MAX_VALUE)
				return i;
		}

		return 0;
	}

	private int binarySearch(int[] minLast, int num) {
		int start = 0, end = minLast.length - 1;
		while (start + 1 < end) {
			int mid = (end - start) / 2 + start;
			if (minLast[mid] < num) {
				start = mid;
			} else {
				end = mid;
			}
		}
		return end;
	}

}
