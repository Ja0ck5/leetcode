package com.ja0ck5.leetcode;

/**
 * 167. Two Sum II - Input array is sorted
 * Easy
 *
 * 826
 *
 * 351
 *
 * Favorite
 *
 * Share
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 *
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 *
 *
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 15:18 2019/4/1
 * @Modified By:
 */
public class TwoSumIIInputarrayissorted {

    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2){
            return new int[]{-1,-1};
        }
        int left = 0;
        int right = numbers.length - 1;
        while(left<right){
            int x = numbers[left] + numbers[right];
            if(target == x){
                return new int[]{left+1,right+1};
            }else if(x > target){
                right--;
            }else{
                left++;
            }
        }
        return new int[]{-1,-1};
    }

}
