package com.ja0ck5.leetcode;

import java.util.Stack;

/**
 *
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 *
 * Input: "(()" Output: 2 Explanation: The longest valid parentheses substring
 * is "()" Example 2:
 *
 * Input: ")()())" Output: 4 Explanation: The longest valid parentheses
 * substring is "()()"
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 15:25 2019/1/8
 * @Modified By:
 */
public class LongestValidParentheses {

	public int longestValidParentheses(String s) {
		if (null == s || s.length() == 0) {
			return 0;
		}
		int res = 0, start = -1;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					res = Math.max(res, i - start);
				} else {
					stack.pop();
					res = Math.max(res, i - stack.peek());
				}
			}
		}
		return res;
	}

}
