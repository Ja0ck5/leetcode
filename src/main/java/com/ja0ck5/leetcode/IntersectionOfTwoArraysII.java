package com.ja0ck5.leetcode;

import java.util.Arrays;

/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * 
 * Note: Each element in the result should appear as many times as it shows in
 * both arrays. The result can be in any order. Follow up: What if the given
 * array is already sorted? How would you optimize your algorithm? What if
 * nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such
 * that you cannot load all elements into the memory at once? Created by Jack on
 * 2018/7/31.
 */
public class IntersectionOfTwoArraysII {

	public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return null;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0,cnt=0;
        int iL = nums1.length;
        int jL = nums2.length;
        int[] res = new int[iL < jL ? iL : jL];
        while(i < iL && j < jL){
            if(nums1[i] == nums2[j]){
                res[cnt++] = nums1[i];
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        return Arrays.copyOf(res,cnt);
    }

}
