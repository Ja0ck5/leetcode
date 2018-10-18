package com.ja0ck5.leetcode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4 Created by Jack on 2018/5/5.
 */
public class MergeTwoSortedLists {

	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				cur.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			cur = cur.next;
		}
		if (l1 != null) {
			cur.next = l1;
		} else {
			cur.next = l2;
		}
		return dummy.next;
	}

	public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
	    if(l1 == null) return l2;
	    if(l2 == null) return l1;
	    if(l1.val< l2.val){
	        l1.next = mergeTwoLists2(l1.next,l2);
	        return l1;
        }else{
            l2.next = mergeTwoLists2(l1,l2.next);
            return l2;
        }
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		ListNode listNode = mergeTwoLists2(l1, l2);
		System.out.println(listNode);
	}



}
