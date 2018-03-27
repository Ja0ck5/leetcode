package com.ja0ck5.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 最长没有重复字母的子串
 */
public class LongestSubStringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, s.charAt(i) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<Character>();
        int res = 0;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < s.length()) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j++));
            } else {
                set.add(s.charAt(i));
                res = Math.max(res, i - j + 1);
                i++;
            }
        }
        return res;
    }
}
