package com.ja0ck5.leetcode;

import java.util.*;

/**
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 *
 * Only one letter can be changed at a time. Each transformed word must exist in
 * the word list. Note that beginWord is not a transformed word. Note:
 *
 * Return 0 if there is no such transformation sequence. All words have the same
 * length. All words contain only lowercase alphabetic characters. You may
 * assume no duplicates in the word list. You may assume beginWord and endWord
 * are non-empty and are not the same. Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
 * "dog" -> "cog", return its length 5. Example 2:
 *
 * Input: beginWord = "hit" endWord = "cog" wordList =
 * ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 *
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 15:21 2019/1/31
 * @Modified By:
 */
public class WordLadder {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict = new HashSet<>();
		for (String word : wordList) {
			dict.add(word);
		}
		if (beginWord.equals(endWord)) {
			return 1;
		}
		Set<String> s = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		q.offer(beginWord);
		s.add(beginWord);

		int len = 1;
		while (!q.isEmpty()) {
			len++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String word = q.poll();
				for (String nextWord : getNextWord(word, dict)) {
					if (s.contains(nextWord)) {
						continue;
					}
					if (nextWord.equals(endWord)) {
						return len;
					}
					s.add(nextWord);
					q.offer(nextWord);
				}
			}
		}

		return 0;
	}

	private List<String> getNextWord(String word, Set<String> dict) {
		List<String> nextWords = new ArrayList<>();
		for (char c = 'a'; c <= 'z'; c++) {
			for (int i = 0; i < word.length(); i++) {
				if (c == word.charAt(i)) {
					continue;
				}
				String nextWord = replace(word, i, c);
				if (dict.contains(nextWord)) {
					nextWords.add(nextWord);
				}
			}
		}
		return nextWords;
	}

	private String replace(String word, int i, char c) {
		char[] chars = word.toCharArray();
		chars[i] = c;
		return new String(chars);
	}

	public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
		Set<String> set = new HashSet<>(wordList);
		if (set.contains(beginWord)) {
			set.remove(beginWord);
		}
		Queue<String> q = new LinkedList<>();
		int level = 1;
		int curNum = 1;
		int nextNum = 0;
		q.offer(beginWord);
		while (!q.isEmpty()) {
			String word = q.poll();
			curNum--;
			for (int i = 0; i < word.length(); i++) {
				char[] wordUnit = word.toCharArray();
				for (char j = 'a'; j <= 'z'; j++) {
					wordUnit[i] = j;
					String temp = new String(wordUnit);
					if(set.contains(temp)){
						if(temp.equals(endWord)){
							return level + 1;
						}else{
							nextNum++;
							q.offer(temp);
							set.remove(temp);
						}
					}
				}
			}
			if(curNum == 0){
				curNum = nextNum;
				nextNum = 0;
				level++;
			}
		}
		return 0;
	}

}
