package com.ja0ck5.leetcode;

/**
 * <img src="./reverseList.jpg"/>
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 11:15 2018/10/18
 * @Modified By:
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode p = head;
        ListNode q = head.next;
        p.next = null;
        ListNode r;
        while(q != null){
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        head = p;
        return head;
    }

}
