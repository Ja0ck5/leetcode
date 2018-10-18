package com.ja0ck5.leetcode;

import com.ja0ck5.TreeNode;

/**
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 17:51 2018/10/18
 * @Modified By:
 */
public class MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int ld = maxDepth(root.left);
        int rd = maxDepth(root.right);
        return ld > rd ? ld + 1 : rd + 1;
    }

}
