package com.ja0ck5.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S, we can transform every letter individually to be lowercase
 * or uppercase to create another string. Return a list of all possible strings
 * we could create.
 *
 * Examples: Input: S = "a1b2" Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * Input: S = "3z4" Output: ["3z4", "3Z4"]
 *
 * Input: S = "12345" Output: ["12345"] Note:
 *
 * S will be a string with length between 1 and 12. S will consist only of
 * letters or digits.
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 9:30 2019/1/16
 * @Modified By:
 */
public class LetterCasePermutation {

	public List<String> letterCasePermutation(String S) {
		List<String> ans = new ArrayList<>();
		dfs(S.toCharArray(), 0, ans);
		return ans;
	}

	private void dfs(char[] S, int i, List<String> ans) {
		if (i == S.length) {
			ans.add(new String(S));
			return;
		}
		dfs(S, i + 1, ans);
		if (!Character.isLetter(S[i]))
			return;
		S[i] ^= 1 << 5;
		dfs(S, i + 1, ans);
		// 不需要回溯的话，可以只 toggle 一次
//		S[i] ^= 1 << 5;
	}

}
