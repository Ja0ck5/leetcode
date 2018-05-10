package com.ja0ck5.leetcode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked
 * list. If the number of nodes is not a multiple of k then left-out nodes in
 * the end should remain as it is.
 * 
 * Example:
 * 
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * Note:
 * 
 * Only constant extra memory is allowed. You may not alter the values in the
 * list's nodes, only nodes itself may be changed. Created by Jack on 2018/5/9.
 */
public class ReverseNodesInKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int count = 0;
        ListNode cur = head;
        while(cur != null && count < k){
            cur = cur.next;
            count++;
        }
        if(count == k){
            cur = reverseKGroup(cur,k);
            while(count-- > 0){
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);

        ListNode res = reverseKGroup(listNode,2);
        System.out.println(res.val);
    }

}
