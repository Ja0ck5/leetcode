package com.ja0ck5.leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of
 *
 * time: O(n*l) strings. Created by Jack on 2018/4/11.
 */
public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		if (null == strs || strs.length == 0)
			return "";
		String res = strs[0];
		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(res) != 0) {
				res = res.substring(0, res.length() - 1);
			}
		}
		return res;
	}

}
