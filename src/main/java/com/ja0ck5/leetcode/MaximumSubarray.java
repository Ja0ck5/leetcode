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

	/**
	 * 直接利用 dp 的思想
	 * @param nums
	 * @return
	 */
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

	/**
	 * 
	 * If you have figured out the O(n) solution, try coding another solution using
	 * the divide and conquer approach, which is more subtle.
	 */
	public int maxSubArray3(int[] nums) {
		return maxArray(nums, 0, nums.length - 1);
	}

	private int maxArray(int[] nums, int left, int right) {
		if (left == right) {
			// 如果只有一个元素
			return nums[left];
		}
		int mid = left + (right - left) / 2;
		// 左子数组的最大子数组的和，包含 mid 下标元素
		int lmax = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = mid; i >= left; i--) {
			sum += nums[i];
			if (sum > lmax) {
				lmax = sum;
			}
		}

		// 右子数组的最大子数组的和，不包含 mid 下标元素
		int rmax = Integer.MIN_VALUE;
		sum = 0;
		for (int i = mid + 1; i <= right; i++) {
			sum += nums[i];
			if (sum > rmax) {
				rmax = sum;
			}
		}
		// 递归 查找左子数组跟右子数组的最大子数组和。
		int maxLR = Integer.max(maxArray(nums,left,mid),maxArray(nums,mid+1,right));
		return Integer.max(maxLR,lmax+rmax);
	}

}
