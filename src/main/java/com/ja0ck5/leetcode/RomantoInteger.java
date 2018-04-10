package com.ja0ck5.leetcode;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999. Created by Jack on
 *
 * 左边的数字 < 右边的数字 = 右边 - 左边
 *
 * 2018/4/10.
 */
public class RomantoInteger {

	public int romanToInt(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int res = toNumber(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			int l = toNumber(s.charAt(i - 1));
			int r = toNumber(s.charAt(i));
			if (r > l) {
				res += r - 2 * l;
			} else {
				res += r;
			}
		}
		return res;

	}

	public static int toNumber(char c) {
		int res = 0;
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		}
		return res;
	}

}
