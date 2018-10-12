package com.ja0ck5.leetcode;

/**
 * The count-and-say sequence is the sequence of integers with the first five
 * terms as following:
 *
 * 1. 1 2. 11 3. 21 4. 1211 5. 111221 1 is read off as "one 1" or 11. 11 is read
 * off as "two 1s" or 21. 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the
 * count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 *
 *
 * Example 1:
 *
 * Input: 1 Output: "1" Example 2:
 *
 * Input: 4 Output: "1211"
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 14:59 2018/10/12
 * @Modified By:
 */
public class CountAndSay {

	public static String countAndSay(int n) {
		if (n == 1) {
			return "1";
		}
		String firstRes = "1";
		String res = "";
		for (int i = 2; i <= n; i++) {
			int count = 1;
			if (i == 2) {
				res = count + firstRes;
				continue;
			}
			int len = res.length();
			char[] chars = res.toCharArray();
			String tmpRes = "";
			for (int j = 0; j < len; j++) {
				char tmp = chars[j];
				if (j == len - 1) {
					tmpRes += (String.valueOf(count) + tmp);
					continue;
				}
				if (chars[j] == chars[j + 1]) {
					count++;
				} else {
					tmpRes += (String.valueOf(count) + tmp);
					count = 1;
				}
			}
			res = tmpRes;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(countAndSay(5));
	}

}
