package com.ja0ck5.leetcode;

/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2 3,2,1 → 1,2,3 1,1,5 → 1,5,1
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 17:44 2019/1/7
 * @Modified By:
 */
public class NextPermutation {

	public void nextPermutation(int[] nums) {
		// find firstSmall
		int firstSmall = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i+1] > nums[i]) {
				firstSmall = i;
				break;
			}
		}
		// can not find firstSmall,reverse
		if (-1 == firstSmall) {
			reverse(nums, 0, nums.length-1);
			return;
		}

		// find firstLarge
		int firstLarge = -1;
		for (int i = nums.length - 1; i > firstSmall; i--) {
			if (nums[firstSmall] < nums[i]) {
				firstLarge = i;
				break;
			}
		}
		// swap
		swap(nums, firstSmall, firstLarge);
		// reverse rest
		reverse(nums, firstSmall + 1, nums.length - 1);
	}

	private void reverse(int[] nums, int lo, int hi) {
		while (lo < hi) {
			swap(nums, lo++, hi--);
		}
	}

	private void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

}
