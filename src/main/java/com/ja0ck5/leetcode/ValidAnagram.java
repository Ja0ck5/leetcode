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
		if (s == null || t == null || s.length() == 0 || t.length() == 0)
			return true;
		if (s.length() != t.length())
			return false;
		char[] schars = s.toCharArray();
		Map<Character, Integer> smap = new HashMap<>();

        char[] tchars = t.toCharArray();
        Map<Character, Integer> tmap = new HashMap<>();

		for (int i = 0; i < schars.length; i++) {
			Integer sc = smap.get(schars[i]);
            sc = sc == null ? 1 : ++sc;
			smap.put(schars[i], sc);

            Integer tc = tmap.get(tchars[i]);
            tc = tc == null ? 1 : ++tc;
            tmap.put(tchars[i], tc);
		}

		boolean flag = true;
		for (int i = 0; i < schars.length; i++) {
			Integer sc = smap.get(schars[i]);
			if (sc == null) {
				flag = false;
				break;
			}
			Integer tc = tmap.get(schars[i]);
			if (tc == null) {
				flag = false;
				break;
			}
			if (sc.intValue() != tc.intValue()) {
				flag = false;
				break;
			}
		}
		return flag;
	}

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        boolean anagram = validAnagram.isAnagram(s, t);
        System.out.println(anagram);
    }

}
