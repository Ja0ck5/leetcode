package com.ja0ck5.leetcode;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * Created by Jack on 2018/4/14.
 */
public class ThreeSumClosest {

	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return 0;
		int res = nums[0] + nums[1] + nums[nums.length - 1];
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int start = i + 1, end = nums.length - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (sum > target) {
					end--;
				} else {
					start++;
				}
				if (Math.abs(sum - target) < Math.abs(res - target)) {
					res = sum;
				}
			}
		}
		return res;
	}

}
