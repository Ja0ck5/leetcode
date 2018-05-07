package com.ja0ck5.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 *
 * 
 * time: O(n!)(2^n) space: O(n)
 * 
 * 卡特兰数: (0,n-1) (1,n-2) (2,n-3) ... (n-1,0)
 *
 * Created by Jack on 2018/5/7.
 */
public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		if (0 == n)
			return res;
		helper(res, "", n, n);
		return res;
	}

	public static void helper(List<String> res, String s, int l, int r) {
		if (l > r) {
			return;
		}
		if (0 == l && 0 == r) {
			res.add(s);
			return;
		}
		if (l > 0) {
			helper(res, "(", l - 1, r);
		}
		if (r > 0) {
			helper(res, "）", l, r - 1);
		}
	}

}
