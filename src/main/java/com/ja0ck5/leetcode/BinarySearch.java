package com.ja0ck5.leetcode;

/**
 * 二分查找
 * 
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 17:30 2019/1/10
 * @Modified By:
 */
public class BinarySearch {

	/**
	 * 递归
	 * 
	 * @param nums
	 * @param lo
	 * @param hi
	 * @param target
	 * @return
	 */
	public int binarySearch(int[] nums, int lo, int hi, int target) {
		if (hi <= lo)
			return -1;
		int mid = (hi - lo) / 2 + lo;
		if (nums[mid] > target) {
			return binarySearch(nums, lo, mid - 1, target);
		} else if (nums[mid] < target) {
			return binarySearch(nums, mid + 1, hi, target);
		} else {
			return mid;
		}
	}

	/**
	 * left <= right
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int binarySearch(int[] nums, int target) {
		int left = 0, right = nums.length - 1;// [left,right]
		while (left <= right) {
			int mid = (right - left) / 2 + left;
			if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	/**
	 * left < right
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public int binarySearch2(int[] nums, int target) {
		int left = 0, right = nums.length;// [left,right)
		while (left < right) {// when left == right then end
			int mid = (right - left) / 2 + left;
			if (nums[mid] < target) {
				left = mid + 1; // [mid+1,right)
			} else if (nums[mid] > target) {
				right = mid;// [left,mid)
			} else {
				return mid;
			}
		}
		return -1;
	}

	/**
	 * left + 1 < right
	 * 相邻则跳出条件
	 * @param nums
	 * @param target
	 * @return
	 */
	public int binarySearch3(int[] nums, int target) {
		int left = 0, right = nums.length - 1;// [left,right]
		while (left + 1 < right) {// when left + 1 == right then end
			int mid = (right - left) / 2 + left;
			if (nums[mid] < target) {
				left = mid; // [mid,right]
			} else if (nums[mid] > target) {
				right = mid;// [left,mid]
			} else {
				return mid;
			}
		}
		if (nums[left] == target)
			return left;
		if (nums[right] == target)
			return right;
		return -1;
	}

}
