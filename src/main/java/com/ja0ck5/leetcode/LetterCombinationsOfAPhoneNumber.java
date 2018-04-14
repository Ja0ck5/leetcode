package com.ja0ck5.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * Input: "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Created by Jack on 2018/4/14.
 */
public class LetterCombinationsOfAPhoneNumber {

	private String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return res;
		}
		helper(res, digits, "", 0);
		return res;
	}

	private void helper(List<String> res, String digits, String s, int index) {
		if (index == digits.length()) {
			res.add(s);
			return;
		}
		String letters = mapping[digits.charAt(index) - '0'];
		for (int i = 0; i < letters.length(); i++) {
			helper(res, digits, s + letters.charAt(i), index + 1);
		}

	}

	public List<String> letterCombinations2(String digits) {
        LinkedList<String> res = new LinkedList<String>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int num = digits.charAt(i) - '0';
            while(res.peek().length() == i){
                String t = res.remove();
                for(char s : mapping[num].toCharArray()){
                    res.add(t + s);
                }
            }
        }
        return res;
    }

}
