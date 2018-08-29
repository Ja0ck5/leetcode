package com.ja0ck5.sort;

import java.util.Arrays;

/**
 * Created by Jack on 2018/8/29.
 */
public class QuickSort {

	public void quick(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
	}

	private void quickSort(int[] nums, int lo, int hi) {
		if (lo < hi) {
			int pivotal = getPivotal(nums, lo, hi);
			quickSort(nums, 0, pivotal-1);
			quickSort(nums, pivotal + 1, hi);
		}
	}

    private int getPivotal(int[] nums, int lo, int hi) {
	    int t = nums[lo];
        while(lo < hi){
            while(lo < hi && t <= nums[hi]){
                hi--;
            }
            nums[lo] = nums[hi];
            while(lo < hi && t >= nums[lo]){
                lo++;
            }
            nums[hi] = nums[lo];
        }
        nums[lo] = t;
	    return lo;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = {1,52,15,13,16,88,77,69,34,0};
        quickSort.quick(nums);
        System.out.println(Arrays.toString(nums));
    }

}
