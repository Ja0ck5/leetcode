package com.ja0ck5.leetcode;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * <p>
 * boolean dp[i][j] s[0-i] --> p[0-j] is Matched?
 * dp[0][0] = true
 * <p>
 * 1. p.charAt(j) == s.charAt(i) : dp[i][j] = dp[i - 1][j - 1]
 * 2. If p.charAt(j) == '.' : dp[i][j] = dp[i - 1][j - 1]
 * 3. If p.charAt(j) == '*'
 * here are two sub conditions
 * 1. If p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j - 2] // in this case,a* only counts as empty
 * 2. If p.charAt(j-1) == s.charAt(i) or p.charAt(j - 1) == '.'
 * : dp[i][j] = dp[i][j-1] // in this case , a* counts as single a
 * : dp[i][j] = dp[i-1][j] // in this case , a* counts as multiple a
 * : dp[i][j] = dp[i][j-2] // in this case , a* counts as empty
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        // Preprocessing
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && p.charAt(i) == '*' && dp[0][i - 1]) {// s="baab",p="bc*aab" c* --> empty
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (j > 0 && p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

}
