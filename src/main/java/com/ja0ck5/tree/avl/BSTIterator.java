package com.ja0ck5.tree.avl;

import com.ja0ck5.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: Ja0ck5
 * @create: 2018-08-01 23:20
 **/
public class BSTIterator {

    private Iterator<Integer> itr;

    public BSTIterator(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        this.itr = list.iterator();
    }

    public void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public boolean hasNext() {
        return itr.hasNext();
    }

    public int next() {
        return itr.next();
    }

}
