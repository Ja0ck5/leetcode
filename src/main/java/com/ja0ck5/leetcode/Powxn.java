package com.ja0ck5.leetcode;

/**
 * 50. Pow(x, n) Medium
 *
 * 779
 *
 * 1938
 *
 * Favorite
 *
 * Share Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Example 1:
 *
 * Input: 2.00000, 10 Output: 1024.00000 Example 2:
 *
 * Input: 2.10000, 3 Output: 9.26100 Example 3:
 *
 * Input: 2.00000, -2 Output: 0.25000 Explanation: 2-2 = 1/22 = 1/4 = 0.25 Note:
 *
 * -100.0 < x < 100.0 n is a 32-bit signed integer, within the range [−231, 231
 * − 1]
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 10:44 2019/4/3
 * @Modified By:
 */
public class Powxn {

	/**
	 * 2^2 = 2^1 * 2^1 = (2^0 * 2^0 * 2) * (2^0 * 2^0 * 2) = (1 * 1 * 2) * (1 * 1 * 2) = 4
     *
     * 2^3 = 2^1 * 2^1 * 2= (2^0 * 2^0 * 2) * (2^0 * 2^0 * 2) * 2 = (1 * 1 * 2) * (1 * 1 * 2) * 2 = 8
	 * 
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow(double x, int n) {
		if (n < 0) {
			return 1.0 / pow(x, n);
		} else {
			return pow(x, n);
		}
	}

	private double pow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		double y = pow(x, n / 2);
		if (n % 2 == 0) {
			return y * y;
		} else {
			return y * y * x;
		}
	}

}
