package com.ja0ck5.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 13:06 2018/10/13
 * @Modified By:
 */
public class HeapTest {

    @Test
    public void  testMemory(){
//        int[] arr = new int[Integer.MAX_VALUE];
//        System.out.println(arr.length);
    }

    /**
     * 1. 完全二叉树
     */
    @Test
    public void testPriorityQueue(){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(50);
        queue.offer(60);
        queue.offer(30);
        queue.offer(25);
        queue.offer(70);
        queue.offer(20);
        queue.offer(10);
        queue.offer(40);
        System.out.println(queue);

        HashSet<Integer> set = new HashSet<>();
        set.add(50);
        set.add(60);
        set.add(30);
        set.add(25);
        set.add(70);
        set.add(20);
        set.add(10);
        set.add(40);

        System.out.println(set);

    }

}
