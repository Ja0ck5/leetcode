package com.ja0ck5.leetcode;

import java.util.PriorityQueue;

/**
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 10:02 2018/10/16
 * @Modified By:
 */
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums,int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int key : nums){
            if(queue.size() < k){
                queue.offer(key);
            }else{
                if(key > queue.peek()){
                    queue.poll();
                    queue.offer(key);
                }
            }
        }
        return queue.peek();
    }

    private void siftDown(int[] array,int p,int heapSize){
        int val = array[p];
        int child;
        while ((child = (p << 1) + 1) <= heapSize){
            if(child+1 <=heapSize){
                child = array[child] >= array[child+1] ? child : child + 1;
            }
            if(val >= array[child]){
                break;
            }
            array[p] = array[child];
            p = child;
        }
        array[p] = val;
    }



}
