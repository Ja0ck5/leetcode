package com.ja0ck5.leetcode;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2. Created by Jack on
 * 2018/4/10.
 */
public class ContainerWithMostWater {

	public int maxArea(int[] height) {
		int res = 0;
		int l = 0;
		int r = height.length - 1;
		while (l < r) {
			res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}
		return res;
	}

}
