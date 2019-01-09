package com.ja0ck5.leetcode;

import java.util.Stack;

/**
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4 Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3 Output: -1
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 18:07 2019/1/8
 * @Modified By:
 */
public class SearchinRotatedSortedArray {

	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int start = 0, end = nums.length - 1;
		while (start + 1 < end) {
			int mid = (end - start) / 2 + start;
			if (nums[mid] == target)
				return mid;
			if (nums[start] < nums[mid]) {
				if (nums[start] <= target && target <= nums[mid]) {
					end = mid;
				} else
					start = mid;
			} else {
				if (nums[mid] <= target && target <= nums[end]) {
					start = mid;
				} else
					end = mid;
			}
		}

		if (nums[start] == target)
			return start;
		if (nums[end] == target)
			return end;
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int search = SearchinRotatedSortedArray.search(nums, 2);
		System.out.println("你怎么知道我再看？" + "不知道，看到鼠标在动吧" + "你可以在这里打字，哈哈哈哈哈" + "别人就不知道我跟谁在聊天了" + "对呀，好神奇，乱打东西是代码吗"
				+ "乱打东西是代码？" + "没~" + "这一串仅仅是 字符串" + "就是文字而已，上面的才是代码，看不懂" + "就是一些 数据结构跟算法的题目，自己玩玩而已" + "" + "无聊，不给你动"
				+ "嘻嘻" + "嘻" + "嘻嘻" + "你太调皮了" + "哈哈哈" + "人家看到以为我在干嘛，转行看" + "哈哈哈，你就说无聊，敲敲代码" + "那我转行好了，敲代码赚钱点，死了，好小的字"
				+ "其实不是字小，是因为你的屏幕小，而我的屏幕很大，所以就" + "我想问，我切换你的屏幕，你会看到吗" + "不会" + "不知道你切换。 \nThis answer:" + +search);
	}

}
