package com.ja0ck5.leetcode;

/**
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication, division and mod operator.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * The integer division should truncate toward zero.
 * 
 * Example 1:
 * 
 * Input: dividend = 10, divisor = 3 Output: 3 Example 2:
 * 
 * Input: dividend = 7, divisor = -3 Output: -2 Note:
 * 
 * Both dividend and divisor will be 32-bit signed integers. The divisor will
 * never be 0. Assume we are dealing with an environment which could only store
 * integers within the 32-bit signed integer range: [−2^31, 2^31 − 1]. For the
 * purpose of this problem, assume that your function returns 2^31 − 1 when the
 * division result overflows. Created by Jack on 2018/5/10.
 */
public class DivideTwoIntegers {

	public int divide(int dividend, int divisor) {
		int sign = 1;
		if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
			sign = -1;
		long ldividend = Math.abs((long) dividend);
		long ldivisor = Math.abs((long) divisor);
		if (ldividend < ldivisor || ldividend == 0)
			return 0;
		long lres = divide(ldividend, ldivisor);
		int res;
		if (lres > Integer.MAX_VALUE) {
			res = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		} else
			res = (int) (sign * lres);
		return res;
	}

	private long divide(long ldividend, long ldivisor) {
		if (ldividend < ldivisor)
			return 0;
		long sum = ldivisor;
		long multiple = 1;
		while ((sum + sum) < ldividend) {
			sum += sum;
			multiple += multiple;
		}
		return multiple + divide(ldividend - sum, ldivisor);
	}

}
