package com.ja0ck5.leetcode;

/**
 * Write a function that takes a string as input and returns the string
 * reversed.
 * 
 * Example 1:
 * 
 * Input: "hello" Output: "olleh" Example 2:
 * 
 * Input: "A man, a plan, a canal: Panama" Output: "amanaP :lanac a ,nalp a ,nam
 * A" Created by Jack on 2018/8/24.
 */
public class ReverseString {

	public String reverseString(String s) {
		if (s == null || s.length() == 0)
			return s;
		char[] arr = s.toCharArray();
		int i = 0, j = arr.length - 1;
		while (i < j) {
			char t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;
			i++;
			j--;
		}
		return new String(arr);
	}

}
