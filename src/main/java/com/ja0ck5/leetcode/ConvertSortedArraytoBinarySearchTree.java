package com.ja0ck5.leetcode;

import com.ja0ck5.TreeNode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 9:54 2018/9/6
 * @Modified By:
 */
public class ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return buildFromSorted(0,nums.length-1,nums);
    }

    public TreeNode buildFromSorted(int lo,int hi,int[] nums){
        if(hi < lo){
            return null;
        }
        int mid = (lo + hi) >>> 1;
        TreeNode left = null;
        if(lo < hi){
            left = buildFromSorted(lo,mid-1,nums);
        }
        TreeNode middle = new TreeNode(nums[mid]);
        if(left != null){
            middle.left = left;
        }
        if(mid < hi){
            TreeNode right =  buildFromSorted(mid+1,hi,nums);
            middle.right = right;
        }
        return middle;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        ConvertSortedArraytoBinarySearchTree convertSortedArraytoBinarySearchTree = new ConvertSortedArraytoBinarySearchTree();
        TreeNode treeNode = convertSortedArraytoBinarySearchTree.sortedArrayToBST(nums);
        System.out.println(treeNode.val);
    }

}
