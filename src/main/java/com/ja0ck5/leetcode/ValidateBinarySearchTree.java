package com.ja0ck5.leetcode;

import com.ja0ck5.TreeNode;

/**
 *Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 *
 * Input:
 *     2
 *    / \
 *   1   3
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 *              is 5 but its right child's value is 4.
 *
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 18:21 2018/10/18
 * @Modified By:
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, long lo, long hi) {
        if(root == null)
            return true;
        if(root.val <= lo || root.val >= hi) return false;
        return dfs(root.left,lo,root.val) && dfs(root.right,root.val,hi);
    }

}
