package com.ja0ck5.tree.avl;

import java.util.Map;

/**
 * @program: leetcode
 * @description:
 * @author: Ja0ck5
 * @create: 2018-08-01 23:02
 **/
public class AVLEntry<K, V> implements Map.Entry<K, V> {

	public K key;
	public V value;
	public AVLEntry<K, V> parent;
	public AVLEntry<K, V> left;
	public AVLEntry<K, V> right;

	public AVLEntry(K key) {
		this.key = key;
	}

	public AVLEntry(K key, V value) {
		this(key);
		this.value = value;
	}

	public AVLEntry(K key, V value, AVLEntry<K, V> left, AVLEntry<K, V> right) {
		this(key, value);
		this.left = left;
		this.right = right;
	}

	public AVLEntry(K key, V value, AVLEntry<K, V> parent, AVLEntry<K, V> left, AVLEntry<K, V> right) {
		this(key, value, left, right);
		this.parent = parent;
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public V setValue(V value) {
		this.value = value;
		return value;
	}
}
