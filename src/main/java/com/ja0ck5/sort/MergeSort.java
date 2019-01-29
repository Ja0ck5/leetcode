package com.ja0ck5.sort;

import java.util.Arrays;

/**
 * 冯诺依曼在1945年发明了归并排序.要知道第一台通用电子计算机1946年才造出来
 * Created by Jack on 2018/8/30.
 */
public class MergeSort {

	public void mergeSort(int[] nums, int left, int right) {
		if (left < right) {
			int mid = (right + left) /2;
			mergeSort(nums, left, mid);
			mergeSort(nums, mid + 1, right);
			merge(nums, left, mid, right);
		}
	}

	private void merge(int[] nums, int left, int mid, int right) {
		int[] aux = new int[nums.length];
		int rs = mid + 1;
		int tmp = left;
		int third = left;
		while (left <= mid && rs <= right) {
			if (nums[left] <= nums[rs]) {
				aux[third++] = nums[left++];
			} else {
				aux[third++] = nums[rs++];
			}
		}

		while (left <= mid) {
			aux[third++] = nums[left++];
		}

		while ((rs <= right)) {
			aux[third++] = nums[rs++];
		}

		while (tmp <= right) {
			nums[tmp] = aux[tmp++];
		}
	}

	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int[] nums = { 1, 52, 15, 13, 16, 88, 77, 69, 34, 0 };
		mergeSort.mergeSort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}

}
