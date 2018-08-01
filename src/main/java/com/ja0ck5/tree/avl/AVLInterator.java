package com.ja0ck5.tree.avl;

import java.util.Iterator;
import java.util.Stack;

/**
 * @program: leetcode
 * @description:
 * @author: Ja0ck5
 * @create: 2018-08-01 23:35
 **/
public class AVLInterator<K, V> implements Iterator<AVLEntry<K, V>> {

    private Stack<AVLEntry<K, V>> stack;

    public AVLInterator(AVLEntry<K, V> root) {
        stack = new Stack<>();
        addLeftPath(root);
    }

    private void addLeftPath(AVLEntry<K, V> root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public AVLEntry<K, V> next() {
        AVLEntry<K, V> p = stack.pop();
        addLeftPath(p.right);
        return p;
    }
}
