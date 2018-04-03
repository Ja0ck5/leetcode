package com.ja0ck5.leetcode;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 * <p>
 * index: 0 1 2 3 4 5
 * num1: 3 5 | 8 9             cut1 4
 * nums2: 1 2 7 | 10 11 12     cut2 6
 * <p>
 * nums3: 1 2 3 5 7 | 8 9 10 11 12
 * <p>
 * L1 <= R2
 * L2 <= R1
 * <p>
 * L1 > R2 cut1 << (cutL,cut1 - 1)
 * L2 > R1 cut1 << (cut1 + 1,cutR)
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int len = n1 + n2;
        int cut1 = 0;
        int cut2 = 0;
        int cutL = 0;
        int cutR = n1;
        while (cut1 <= n1) {
            cut1 = ((cutR - cutL) >> 1) + cutL;
            cut2 = (len >> 1) - cut1;

            double L1 = (0 == cut1) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double L2 = (0 == cut2) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R1 = (nums1.length == cut1) ? Integer.MAX_VALUE : nums1[cut1];
            double R2 = (nums2.length == cut2) ? Integer.MAX_VALUE : nums2[cut2];

            if (L1 > R2) {
                cutR = cut1 - 1;
            } else if (L2 > R1) {
                cutL = cut1 + 1;
            } else {
                if (len % 2 == 0) {
                    L1 = (L1 > L2 ? L1 : L2);
                    R1 = (R1 < R2 ? R1 : R2);
                    return (L1 + R1) / 2;
                } else {
                    R1 = (R1 < R2 ? R1 : R2);
                    return R1;
                }
            }

        }
        return -1;
    }
}
