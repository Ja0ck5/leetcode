package com.ja0ck5.leetcode;

import java.util.Arrays;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Example 1:
 *
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 *
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 * @author liyanjie
 */
public class FindtheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int start = 0,mid,target;
            target = nums[i];
            int end = nums.length - 1;
            while(start + 1 < end){
                mid = (end - start)/2+start;
                if(mid != i && nums[mid] == target){
                    return target;
                }else if(nums[mid] < target){
                    start = mid;
                }else{
                    end = mid;
                }
            }
            if(start != i && target == nums[start]) return target;
            if(end != i && target == nums[end]) return target;
        }
        return 0;
    }

}
