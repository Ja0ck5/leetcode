package com.ja0ck5.leetcode;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets. Open brackets must
 * be closed in the correct order. Note that an empty string is also considered
 * valid.
 * 
 * Example 1:
 * 
 * Input: "()" Output: true
 * <p>
 * Example 2: Input: "()[]{}" Output: true
 * </p>
 * <p>
 * Example 3: Input: "(]" Output: false
 * </p>
 * 
 * <p>
 * Example 4: Input: "([)]" Output: false
 * </p>
 * Example 5:
 * 
 * Input: "{[]}" Output: true
 *
 * use stack
 *
 * Created by Jack on 2018/4/19.
 */
public class ValidParentheses {

	public boolean isValid(String s) {
		if (s == null || s.length() == 0)
			return true;
		Stack<Character> stack = new Stack<Character>();
		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				stack.push(')');
			} else if (ch == '[') {
				stack.push(']');
			} else if (ch == '{') {
				stack.push('}');
			} else {
				if (stack.isEmpty() || stack.pop() != ch) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

}
