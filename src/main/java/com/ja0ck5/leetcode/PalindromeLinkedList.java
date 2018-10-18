package com.ja0ck5.leetcode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2 Output: false Example 2:
 *
 * Input: 1->2->2->1 Output: true Follow up: Could you do it in O(n) time and
 * O(1) space?
 * 
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 15:55 2018/10/18
 * @Modified By:
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rl = reverse(slow);
        while(head != null && rl != null){
            if(head.val != rl.val)
                return false;
            head = head.next;
            rl = rl.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        if (head == null || head.next == null)
            return head;
        ListNode p = null;
        ListNode q;
        while (head != null) {
            q = head.next;
            head.next = p;
            p = head;
            head = q;
        }
        return p;
    }

    public static void main(String[] args) {
        PalindromeLinkedList pll = new PalindromeLinkedList();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(1);
        boolean palindrome = pll.isPalindrome(l1);
        System.out.println(palindrome);
    }

}
