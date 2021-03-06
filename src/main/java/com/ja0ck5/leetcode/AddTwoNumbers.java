package com.ja0ck5.leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 +
 * 465 = 807.
 * 
 * Created by Jack on 2018/3/27.
 */
public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		int sum = 0;
		ListNode cur = dummy;
		ListNode p1 = l1, p2 = l2;
		while (p1 != null || p2 != null) {
			if (p1 != null) {
				sum += p1.val;
				p1 = p1.next;
			}
			if (p2 != null) {
				sum += p2.val;
				p2 = p2.next;
			}
			cur.next = new ListNode(sum % 10);
			sum /= 10;// 如果 和为 10 则进 1 位
			cur = cur.next;
		}
		if (sum == 1) {// 最后一位相加 还是 大于等于 10,则继续进一位
			cur.next = new ListNode(1);
		}
		return dummy.next;
	}

}
