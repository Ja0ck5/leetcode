package com.ja0ck5.leetcode;

import java.util.PriorityQueue;

/**
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 10:02 2018/10/16
 * @Modified By:
 */
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int key : nums) {
            if (queue.size() < k) {
                queue.offer(key);
            } else {
                if (key > queue.peek()) {
                    queue.poll();
                    queue.offer(key);
                }
            }
        }
        return queue.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        int n = nums.length;
        for (int i = n >>> 1; i >= 0; i--) {
            siftDown(nums, i, n - 1);
        }
        int res = nums[0];
        for (int i = 0; i < k; i++) {
            res = nums[0];
            swap(nums, 0, n - i - 1);
            siftDown(nums, 0, n - 2 - i);
        }
        return res;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }


    private void siftDown(int[] array, int p, int heapSize) {
        int val = array[p];
        int child;
        while ((child = (p << 1) + 1) <= heapSize) {
            if (child + 1 <= heapSize) {
                child = array[child] >= array[child + 1] ? child : child + 1;
            }
            if (val >= array[child]) {
                break;
            }
            array[p] = array[child];
            p = child;
        }
        array[p] = val;
    }


}
