package com.ja0ck5.leetcode;

import java.util.Arrays;

/**
 * iven an array, rotate the array to the right by k steps, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,4,5,6,7] and k = 3 Output: [5,6,7,1,2,3,4] Explanation: rotate
 * 1 steps to the right: [7,1,2,3,4,5,6] rotate 2 steps to the right:
 * [6,7,1,2,3,4,5] rotate 3 steps to the right: [5,6,7,1,2,3,4] Example 2:
 * 
 * Input: [-1,-100,3,99] and k = 2 Output: [3,99,-1,-100] Explanation: rotate 1
 * steps to the right: [99,-1,-100,3] rotate 2 steps to the right:
 * [3,99,-1,-100] Note:
 * 
 * Try to come up as many solutions as you can, there are at least 3 different
 * ways to solve this problem. Could you do it in-place with O(1) extra space?
 * Created by Jack on 2018/7/23.
 */
public class RotateArray {

	public static void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return;
		k %= nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	private static void reverse(int[] nums, int l, int r) {
		while (l < r) {
			int t = nums[l];
			nums[l++] = nums[r];
			nums[r--] = t;
		}
	}

    public static void main(String[] args) {
	    int[] nums = {1,2,3,4,5,6,7}; int k=3;
        RotateArray.rotate(nums,k);
        System.out.println(Arrays.toString(nums));
    }

}
