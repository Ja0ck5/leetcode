package com.ja0ck5.linkedList;

import com.ja0ck5.leetcode.ListNode;

/**
 * 链表中倒数第k个结点
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 10:58 2019/2/26
 * @Modified By:
 */
public class FindKthToTail {

    public ListNode FindKthToTail(ListNode head, int k) {
        if(head == null || k == 0){
            return null;
        }
        ListNode temp = head;
        // 判断第 K 个节点是否存在
        for (int i = 0; i < k - 1; i++) {
            if(temp.next != null){
                temp = temp.next;
            }else{
                return null;
            }
        }

        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    // 使用 stack的方法，把链表按顺序压入stack,然后直接取出stack的第k个节点

}
