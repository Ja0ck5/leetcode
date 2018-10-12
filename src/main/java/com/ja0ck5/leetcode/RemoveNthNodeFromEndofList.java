package com.ja0ck5.leetcode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its
 * head.
 * 
 * Example:
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5. Note:
 * 
 * Given n will always be valid. Created by Jack on 2018/4/19.
 */
public class RemoveNthNodeFromEndofList {

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		ListNode slow = dummy;
		ListNode fast = dummy;
		dummy.next = head;
		for (int i = 0; i <= n; i++) {
			fast = fast.next;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);

		ListNode res = removeNthFromEnd(node, 2);
		System.out.println(res);

	}

}
