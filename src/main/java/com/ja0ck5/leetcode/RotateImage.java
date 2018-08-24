package com.ja0ck5.leetcode;

/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Note:
 * 
 * You have to rotate the image in-place, which means you have to modify the
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 * 
 * Example 1:
 * 
 * Given input matrix = [ [1,2,3], [4,5,6], [7,8,9] ],
 * 
 * rotate the input matrix in-place such that it becomes: [ [7,4,1], [8,5,2],
 * [9,6,3] ] Example 2:
 * 
 * Given input matrix = [ [ 5, 1, 9,11], [ 2, 4, 8,10], [13, 3, 6, 7],
 * [15,14,12,16] ],
 * 
 * rotate the input matrix in-place such that it becomes: [ [15,13, 2, 5], [14,
 * 3, 4, 1], [12, 6, 8, 9], [16, 7,10,11] ] Created by Jack on 2018/8/24.
 */
public class RotateImage {

	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - 1 - i; j++) {
                int tmp = matrix[i][j];
                // i=0,j=0 为例,最后一行第一列 --> 第一行第一列
                matrix[i][j] = matrix[n-1-j][i];
                // 最后一行最后一列 --> 最后一行第一列
                matrix[n-1-j][i] =  matrix[n-1-i][n-1-j];
                // 最后一列第一行 --> 最后一行第一列
                matrix[n-1-i][n-1-j] =  matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
			}
		}
	}

}
