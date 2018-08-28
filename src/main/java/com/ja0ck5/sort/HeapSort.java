package com.ja0ck5.sort;

import java.util.Arrays;

/**
 * 堆排序 Created by Jack on 2018/8/28.
 */
public class HeapSort {

	public void heapSort(int[] nums) {
	    if(nums == null || nums.length < 2){
	        return;
        }
		// 构建大堆
		buildMaxHeap(nums);
		// 现在已经有了 最大元素排到了 下标为 0 的位置
        for (int i = nums.length - 1; i >= 1 ; i--) {
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;// 这里已经沉淀了大元素

            adjustHeap(nums,i,0);
        }
    }

	/**
	 * 自底向上 构建大堆 left = 2i+1 right = 2i + 2
	 * 
	 * @param nums
	 */
	private void buildMaxHeap(int[] nums) {
		for (int i = ((nums.length - 1) >> 1); i >= 0; i--) {
			// 构造大堆需要的数组，要构造的元素的数量，要构造的元素从哪个节点开始
			adjustHeap(nums, nums.length, i);
		}
	}

	private void adjustHeap(int[] nums, int length, int i) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
	    int largest = i;// 根节点
	    if(left < length && nums[left] > nums[i]){
	        // 左孩子 大于 根节点
            largest = left;
        }

        if(right < length && nums[right] > nums[largest]){
            // 右孩子 大于 根节点
            largest = right;
        }

        if(i != largest){
            // exchange
            int tmp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = tmp;
            // 交换完之后，将较大的节点上浮，largest 为变化的那个节点
            adjustHeap(nums,length,largest/* 变化的那个节点 */);
        }

	}


    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] nums = {1,52,15,13,16,88,77,69,34,0};
        heapSort.heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
