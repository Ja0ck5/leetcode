package com.ja0ck5.tree.avl;

import java.util.Comparator;
import java.util.Iterator;

/**
 * @program: leetcode
 * @description:
 * @author: Ja0ck5
 * @create: 2018-08-01 23:07
 **/
public class AVLMap<K, V> implements Iterable<AVLEntry<K, V>> {

    private int size;
    private AVLEntry<K, V> root;
    private Comparator comp;

    private int compare(K a, K b) {
        if (null != comp) {
            return comp.compare(a, b);
        } else {
            Comparable<K> c = (Comparable<K>) a;
            return c.compareTo(b);
        }
    }


    public AVLMap(Comparator comp) {
        this.comp = comp;
    }

    public AVLMap() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V put(K key, V value) {
        if (root == null) {
            root = new AVLEntry<K, V>(key, value);
            size++;
        } else {
            AVLEntry<K, V> p = root;
            while (p != null) {
                int compRes = compare(key, p.key);
                if (compRes == 0) {
                    p.setValue(value);
                    break;
                } else if (compRes < 0) {
                    if (p.left == null) {
                        p.left = new AVLEntry<>(key, value);
                        size++;
                        break;
                    } else {
                        p = p.left;
                    }
                } else {
                    if (p.right == null) {
                        p.right = new AVLEntry<>(key, value);
                        size++;
                        break;
                    } else {
                        p = p.right;
                    }
                }
            }
        }
        return value;
    }

    @Override
    public Iterator<AVLEntry<K, V>> iterator() {
        return new AVLInterator<>(root);
    }
}
