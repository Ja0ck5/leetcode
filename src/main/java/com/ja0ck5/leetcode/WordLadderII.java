package com.ja0ck5.leetcode;

import java.util.*;

/**
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 17:28 2019/2/12
 * @Modified By:
 */
public class WordLadderII {

	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> ladders = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		Map<String, Integer> distance = new HashMap<>();

		dict.add(start);
		dict.add(end);

		bfs(map, distance, start, end, dict);

		List<String> path = new ArrayList<>();

		dfs(ladders, path, end, start, distance, map);

		return ladders;
	}

	void dfs(List<List<String>> ladders, List<String> path, String crt, String start, Map<String, Integer> distance,
			Map<String, List<String>> map) {
		path.add(crt);
		if (crt.equals(start)) {
			Collections.reverse(path);
			ladders.add(new ArrayList<>(path));
			Collections.reverse(path);
		} else {
			for (String next : map.get(crt)) {
				if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) {
					dfs(ladders, path, next, start, distance, map);
				}
			}
		}
		path.remove(path.size() - 1);
	}

	void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String start, String end, Set<String> dict) {
		Queue<String> q = new LinkedList<>();
		q.offer(start);
		distance.put(start, 0);
		for (String s : dict) {
			map.put(s, new ArrayList<>());
		}

		while (!q.isEmpty()) {
			String crt = q.poll();

			List<String> nextList = expand(crt, dict);
			for (String next : nextList) {
				map.get(next).add(crt);
				if (!distance.containsKey(next)) {
					distance.put(next, distance.get(crt) + 1);
					q.offer(next);
				}
			}
		}
	}

	List<String> expand(String crt, Set<String> dict) {
		List<String> expansion = new ArrayList<>();

		for (int i = 0; i < crt.length(); i++) {
			for (char ch = 'a'; ch <= 'z'; ch++) {
				if (ch != crt.charAt(i)) {
					String expanded = crt.substring(0, i) + ch + crt.substring(i + 1);
					if (dict.contains(expanded)) {
						expansion.add(expanded);
					}
				}
			}
		}

		return expansion;
	}

	public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> res = new ArrayList<>();
		if (wordList.size() == 0)
			return res;

		int curNum = 1;
		int nextNum = 0;
		boolean found = false;

		Queue<String> q = new LinkedList<>();
		Set<String> unvisited = new HashSet<>(wordList);
		Set<String> visited = new HashSet<>();
		Map<String, List<String>> map = new HashMap<>();

		q.offer(beginWord);
		while (!q.isEmpty()) {
			String word = q.poll();
			curNum--;
			for (int i = 0; i < word.length(); i++) {
				StringBuilder builder = new StringBuilder(word);
				for (char ch = 'a'; ch <= 'z'; ch++) {
					builder.setCharAt(i, ch);
					String newWord = builder.toString();
					if (unvisited.contains(newWord)) {
						if (visited.add(newWord)) {
							nextNum++;
							q.offer(newWord);
						}
						if (map.containsKey(newWord)) {
							map.get(newWord).add(word);
						} else {
							List<String> list = new ArrayList<>();
							list.add(word);
							map.put(newWord, list);
						}
						if (newWord.equals(endWord)) {
							found = true;
						}
					}
				}
			}
			if (curNum == 0) {
				if (found)
					break;
				curNum = nextNum;
				nextNum = 0;
				unvisited.removeAll(visited);
				visited.clear();
			}

		}
		dfs(res, new ArrayList<>(), map, endWord, beginWord);
		return res;
	}

	private void dfs(List<List<String>> res, List<String> list, Map<String, List<String>> map, String word,
			String start) {
		if (word.equals(start)) {
			list.add(0, start);
			res.add(new ArrayList<>(list));
			// list.remove(list.size - 1)
			list.remove(0);
			return;
		}
		list.add(0, word);
		if (map.get(word) != null) {
			for (String s : map.get(word)) {
				dfs(res, list, map, s, start);
			}
		}
		list.remove(0);
	}
}
