package com.ja0ck5.leetcode;

import java.util.*;

/**
 *
 * Given string S and a dictionary of words words, find the number of words[i]
 * that is a subsequence of S.
 *
 * Example : Input: S = "abcde" words = ["a", "bb", "acd", "ace"] Output: 3
 * Explanation: There are three words in words that are a subsequence of S: "a",
 * "acd", "ace". Note:
 *
 * All words in words and S will only consists of lowercase letters. The length
 * of S will be in the range of [1, 50000]. The length of words will be in the
 * range of [1, 5000]. The length of words[i] will be in the range of [1, 50].
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 11:50 2019/1/14
 * @Modified By:
 */
public class NumberofMatchingSubsequences {

	public static int numMatchingSubseq(String S, String[] words) {
		int ans = 0;
		Set<String> subsequenceSet = new HashSet<>();
		int[] alphabet = new int[26];
		char[] chars = S.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			alphabet[chars[i] - 'a']++;
		}
		for (int i = 0; i < words.length; i++) {
			if (subsequenceSet.contains(words[i])) {
				ans++;
			} else if (isSubsequence(chars, alphabet, words[i])) {
				subsequenceSet.add(words[i]);
				ans++;
			}
		}
		return ans;

	}

	private static boolean isSubsequence(char[] chars, int[] alphabet, String word) {
		char[] charWord = word.toCharArray();
		int[] alphWord = new int[26];
		for (int i = 0; i < charWord.length; i++) {
			alphWord[charWord[i] - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (alphWord[i] > alphabet[i]) {
				return false;
			}
		}

		int m = 0, n = 0;
		while (m < chars.length && n < charWord.length) {
			if (chars[m] == charWord[n]) {
				n++;
			}
			m++;
		}
		return n == charWord.length;
	}

	/**
	 * The Second approach
	 */
	private static List<List<Integer>> pos;

	private static boolean isMatch(String word) {
		int l = -1;
		for (char c : word.toCharArray()) {
			List<Integer> p = pos.get(c);
			// 因为不知道下一个具体 l 为多少，所以 +1 ,拿到最近的下一个 idx
			int idx = Collections.binarySearch(p, l + 1);
			if (idx < 0)
				// 因为 idx = -(insertion point) - 1 所以得到 insertion point 需要翻译回来
				idx = -idx - 1;
			if (idx >= p.size())// 找不到了
				return false;
			// 拿到下一个 c 位置
			l = p.get(idx);
		}
		return true;
	}

	public static int numMatchingSubseq2(String S, String[] words) {
		pos = new ArrayList<>();
		for (int i = 0; i < 128; i++) {
			pos.add(new ArrayList<>());
		}
		char[] s = S.toCharArray();
		for (int i = 0; i < s.length; i++) {
			pos.get(s[i]).add(i);
		}
		int ans = 0;
		for (String w : words) {
			if (isMatch(w))
				++ans;
		}
		return ans;
	}

	public static void main(String[] args) {
		String s = "abscdedddabbacsdadfasdfasxcfasdfasfedfasfqwcefasdfc";
		String[] words = { "affffffff", "bb", "aff" };
		// numMatchingSubseq(s, words);
		numMatchingSubseq2(s, words);
	}

}
