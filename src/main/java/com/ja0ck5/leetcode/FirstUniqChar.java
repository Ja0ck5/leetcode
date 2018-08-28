package com.ja0ck5.leetcode;

/**
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode" return 0.
 * 
 * s = "loveleetcode", return 2. Note: You may assume the string contain only
 * lowercase letters. Created by Jack on 2018/8/28.
 */
public class FirstUniqChar {

    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) return -1;
        int res = -1;
        char[] chars = s.toCharArray();
        for (char i = 'a'; i <= 'z'; i++) {
            int idx = s.indexOf(i);
            if(idx != -1 && idx == s.lastIndexOf(i)){
                res = res != -1 ? Math.min(res,idx) : idx;
            }
        }
        return res;
    }

}
