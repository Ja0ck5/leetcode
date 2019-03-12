package com.ja0ck5.leetcode;

import java.util.HashMap;
import java.util.Map;

class RandomListNode{
    public RandomListNode(int label) {
        this.label = label;
    }

    int label;
    RandomListNode next;
    RandomListNode random;
}
/**
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 20:42 2019/3/12
 * @Modified By:
 */
public class CopyListwithRandomPointer {


    public RandomListNode copyRandomList(RandomListNode head){
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while(cur != null){
            map.put(cur,new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

}
