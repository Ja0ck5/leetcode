package com.ja0ck5.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 * 
 * Example 1:
 * 
 * Input: s = "barfoothefoobarman", words = ["foo","bar"] Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar"
 * respectively. The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 * 
 * Input: s = "wordgoodstudentgoodword", words = ["word","student"] Output: []
 * Created by Jack on 2018/5/23.
 */
public class SubstringWithConcatenationOfAllWords {

	public List<Integer> findSubstring(String s, String[] words) {
		if (s == null || words == null || words.length == 0)
			return new ArrayList<>();
		List<Integer> res = new ArrayList<>();
		int n = words.length;
		int m = words[0].length();
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1/* 出现次数 */);
		}

		for (int i = 0; i <= s.length() - (n * m/* 可合成的字符串总长度 */); i++) {
			Map<String, Integer> copy = new HashMap<>(map);
			int k = n;
			int j = i;
			while (k > 0) {
				String str = s.substring(j, j + m/* 跨越每个单词的长度 */);
				if (!copy.containsKey(str) || copy.get(str) < 1) {// 不存在
					break;
				}
				copy.put(str, copy.get(str) - 1);
				k--;
				j += m;
			}
			if (0 == k)// 比较完了
				res.add(i);
		}

		return res;
	}

}
