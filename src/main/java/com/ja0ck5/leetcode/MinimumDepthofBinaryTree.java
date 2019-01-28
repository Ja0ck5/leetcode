package com.ja0ck5.leetcode;

import com.ja0ck5.TreeNode;

/**
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
 * return its minimum depth = 2.
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 15:36 2019/1/28
 * @Modified By:
 */
public class MinimumDepthofBinaryTree {

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return getMin(root);
    }

    private int getMin(TreeNode node){
        if(node == null){
            return Integer.MAX_VALUE;
        }
        if(node.left == null && node.right == null){
            return 1;
        }
        return Math.min(getMin(node.left),getMin(node.right)) + 1;
    }


    /**
     * 解法 2
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if(root == null){
            return 0;
        }
        int ld = minDepth2(root.left);
        int rd = minDepth2(root.right);

        if(ld == 0){
            return rd + 1;
        }else if(rd == 0){
            return ld + 1;
        }else{
            return Math.min(ld,rd) + 1;
        }
    }

}
