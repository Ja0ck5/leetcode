package com.ja0ck5.leetcode;

import com.ja0ck5.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 11:39 2019/1/28
 * @Modified By:
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Stack<TreeNode> curLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        Stack<TreeNode> tmp;
        curLevel.push(root);
        boolean flag = true;
        while(!curLevel.isEmpty()){
            List<Integer> list = new ArrayList<>();
            while(!curLevel.isEmpty()){
                TreeNode node = curLevel.pop();
                list.add(node.val);
                if(flag){
                    if(node.left != null){
                        nextLevel.push(node.left);
                    }
                    if(node.right != null){
                        nextLevel.push(node.right);
                    }
                }else{
                    if(node.right != null){
                        nextLevel.push(node.right);
                    }
                    if(node.left != null){
                        nextLevel.push(node.left);
                    }
                }
            }
            res.add(list);
            tmp = curLevel;
            curLevel = nextLevel;
            nextLevel = tmp;
            flag = !flag;
        }
        return res;
    }

}
