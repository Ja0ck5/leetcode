package com.ja0ck5.leetcode;

import com.ja0ck5.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 *
 * For example: Given binary tree [3,9,20,null,null,15,7], 3 / \ 9 20 / \ 15 7
 * return its level order traversal as: [ [3], [9,20], [15,7] ]
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 15:08 2018/10/19
 * @Modified By:
 */
public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null)
			return new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode p = queue.poll();
				list.add(p.val);
				if (p.left != null) {
					queue.offer(p.left);
				}
				if (p.right != null) {
					queue.offer(p.right);
				}
			}
			res.add(list);
		}
		return res;
	}

}
