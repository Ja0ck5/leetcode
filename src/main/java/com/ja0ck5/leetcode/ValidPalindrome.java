package com.ja0ck5.leetcode;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 * 
 * Example 1:
 * 
 * Input: "A man, a plan, a canal: Panama" Output: true Example 2:
 * 
 * Input: "race a car" Output: false Created by Jack on 2018/8/30.
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0)
			return true;
		char[] chars = s.toCharArray();
		int lo = 0;
		int hi = chars.length - 1;
		while (lo < hi) {
			while (lo < hi && !isAlpha(chars[lo]))
				lo++;
			while (hi > 0 && !isAlpha(chars[hi]))
				hi--;

			if (lo > hi) {
				break;
			}

			if (Character.toLowerCase(chars[lo]) == Character.toLowerCase(chars[hi])) {
				lo++;
				hi--;
			} else {
				return false;
			}

		}
		return true;
	}

	public boolean isAlpha(char ch) {
		return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
	}

}
