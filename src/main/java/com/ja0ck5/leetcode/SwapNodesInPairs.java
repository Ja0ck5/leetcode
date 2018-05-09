package com.ja0ck5.leetcode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * Example:
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3. Note:
 * 
 * Your algorithm should use only constant extra space. You may not modify the
 * values in the list's nodes, only nodes itself may be changed. Created by Jack
 * on 2018/5/8.
 */
public class SwapNodesInPairs {

	public static ListNode swapPairs(ListNode head) {
	    if(head == null || head.next == null) return head;
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode l1 = dummy;
	    ListNode l2 = head;

	    while(l2 != null && l2.next != null){
	        ListNode nextStart = l2.next.next;
	        l1.next =l2.next;
            l2.next.next = l2;
	        l2.next = nextStart;
	        l1 = l2;
	        l2 = l2.next;
        }

        return dummy.next;
	}

	public static void main(String[] args) {
		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(3);
		listNode.next.next.next = new ListNode(4);

		ListNode res = swapPairs(listNode);
		System.out.println(res.val);
	}

}
