package com.ja0ck5.leetcode;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example:
 * <p>
 * Input: "babad"
 * <p>
 * Output: "bab"
 * <p>
 * Note: "aba" is also a valid answer.
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: "cbbd"
 * <p>
 * Output: "bb"
 * <p>
 * 1. dp
 * 2. 中心扩散法
 */
public class LongestPalindromicSubstring {

    //  time O(n^2) space:O(n^2)
    public String longestPalindrome(String s) {
        if (null == s || s.length() == 0) return s;
        int len = s.length();
        String res = "";
        boolean[][] dp = new boolean[len][len];
        int max = 0;
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2 || dp[i + 1][j - 1]/** 上一个也是回文*/));
                if (dp[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }

    String res = "";

    //  中心扩散法 time O(n^2) space:O(1)
    public String longestPalindrome2(String s) {
        if (null == s || s.length() == 0) return s;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return res;
    }

    public void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        String cur = s.substring(left + 1, right);
        if (cur.length() > res.length()) {
            res = cur;
        }
    }


    int max = 0, lo = 0;

    void calPalindrome(String s , int l, int h)
    {
        while(l>=0 && h< s.length() && s.charAt(l) == s.charAt(h))
        {
            l--;
            h++;
        }
        if(h-l-1>=max)
        {
            max = h-l-1;
            lo = l+1;
        }
    }

    public String longestPalindrome3(String s) {

        if(s.length() < 2 )return s;

        for(int i =0;i<s.length();i++)
        {
            calPalindrome(s,i,i);
            calPalindrome(s,i,i+1);
        }

        return s.substring(lo,lo+max);

    }
}
