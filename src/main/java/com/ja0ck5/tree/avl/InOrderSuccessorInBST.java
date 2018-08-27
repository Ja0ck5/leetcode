package com.ja0ck5.tree.avl;

import com.ja0ck5.TreeNode;

/**
 * Created by Jack on 2018/8/27.
 */
public class InOrderSuccessorInBST {

	/**
	 * 
	 * @param root
	 *            The root of the BST
	 * @param p
	 *            u need find the successor node of p
	 * @return successor of p
	 */
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null)
			return null;

		// case 1: 本身就是 root
		if (getLastEntry(root) == p) {
			return null;
		}
		// case 2: 有右子树
		if (p.right != null) {
			return getFirstEntry(p);
		}
		// case 3: 没有右子树
		TreeNode parent = root;
		TreeNode tmp = root;
		while (parent != null) {
			if (parent == p) {
				break;
			} else if (p.val < parent.val) {
				tmp = parent;
				parent = parent.left;
			} else {
				parent = parent.right;
			}
		}
		return tmp;
	}

	private TreeNode getFirstEntry(TreeNode p) {
		if (p == null)
			return p;
		while (p.left != null) {
			p = p.left;
		}
		return p;
	}

	private TreeNode getLastEntry(TreeNode p) {
		if (p == null)
			return p;
		while (p.right != null) {
			p = p.right;
		}
		return p;
	}

}
