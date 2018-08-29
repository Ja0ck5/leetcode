package com.ja0ck5.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t , write a function to determine if t is an anagram
 * of s.
 * 
 * Example 1:
 * 
 * Input: s = "anagram", t = "nagaram" Output: true Example 2:
 * 
 * Input: s = "rat", t = "car" Output: false Note: You may assume the string
 * contains only lowercase alphabets.
 * 
 * Follow up: What if the inputs contain unicode characters? How would you adapt
 * your solution to such case?
 * 
 * Created by Jack on 2018/8/29.
 */
public class ValidAnagram {

	public boolean isAnagram(String s, String t) {
		if(s == null || t == null || s.length() ==0 || t.length() == 0 ) return true;
		if(s.length() != t.length()) return false;
		int[] a = new int[26];
		int[] b = new int[26];
		char[] schars = s.toCharArray();
		char[] tchars = t.toCharArray();

		for(int i=0;i<schars.length;i++){
			a[schars[i] - 97]++;
			b[tchars[i] - 97]++;
		}
		for(int i=0;i<a.length;i++){
			if(a[i] != b[i]) return false;
		}

		return true;
	}

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        boolean anagram = validAnagram.isAnagram(s, t);
        System.out.println(anagram);
    }

}
