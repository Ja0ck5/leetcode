package com.ja0ck5.leetcode;

import com.ja0ck5.TreeNode;

import java.util.Stack;

/**
 * 230. Kth Smallest Element in a BST
 * Medium
 *
 * 1118
 *
 * 39
 *
 * Favorite
 *
 * Share
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 *
 * @author liyanjie
 */
public class KthSmallestElementinaBST {

    public int kthSmallest(TreeNode root, int k) {
        TreeNode cur = root;
        Stack<TreeNode> s = new Stack<>();
        while(cur != null || !s.isEmpty()){
            while (cur != null){
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            if(--k == 0){
                break;
            }
            cur = cur.right;
        }
        return cur.val;
    }

}
