package com.ja0ck5.leetcode;

import java.util.PriorityQueue;

/**
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * Input: [ 1->4->5, 1->3->4, 2->6 ] Output: 1->1->2->3->4->4->5->6
 * 
 * Created by Jack on 2018/5/7.
 */
public class MergekSortedLists {

	/**
	 * time: O(nlogk) where k is the number of linked list space: O(n)
	 * 
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		return sort(lists, 0, lists.length - 1);
	}

	public static ListNode sort(ListNode[] lists, int lo, int hi) {
		if (lo >= hi)
			return lists[lo];
		int mid = (hi - lo) / 2 + lo;
		ListNode l1 = sort(lists, lo, mid);
		ListNode l2 = sort(lists, mid + 1, hi);
		return merge(l1, l2);
	}

	public static ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			l1.next = merge(l1.next, l2);
			return l1;
		}
		l2.next = merge(l1, l2.next);
		return l2;
	}

	/**
	 * # Approach 2 PriorityQueue
	 * 
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists2(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		for (ListNode list : lists) {
			if (list != null) {
				queue.add(list);
			}
		}
		while (!queue.isEmpty()) {
			cur.next = queue.poll();
			cur = cur.next;
			if (cur.next != null) {
				queue.add(cur.next);
			}
		}
		return dummy.next;
	}

}
