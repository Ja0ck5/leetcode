package com.ja0ck5.tree.avl;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

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

	private AVLEntry<K, V> getEntry(K key) {
		AVLEntry<K, V> p = this.root;
		while (p != null) {
			int res = compare(key, p.key);
			if (res == 0) {
				return p;
			} else if (res < 0) {
				p = p.left;
			} else {
				p = p.right;
			}
		}
		return null;
	}

	public boolean containsKey(K key) {
		return getEntry(key) != null;
	}

	public V get(K key) {
		AVLEntry<K, V> entry = getEntry(key);
		return entry != null ? entry.getValue() : null;
	}

	public boolean containsValue(V value) {
		Iterator<AVLEntry<K, V>> iterator = this.iterator();
		while (iterator.hasNext()) {
			if (iterator.next() == value) {
				return true;
			}
		}
		return false;
	}

	AVLEntry<K, V> getFirstEntry(AVLEntry<K, V> p) {
		if (p != null) {
			while (p.left != null) {
				p = p.left;
			}
		}
		return p;
	}

	AVLEntry<K, V> getLastEntry(AVLEntry<K, V> p) {
		if (p != null) {
			while (p.right != null) {
				p = p.right;
			}
		}
		return p;
	}

	/**
	 * 
	 * @param p
	 *            在子树 P 中删除 key
	 * @param key
	 * @return
	 */
	private AVLEntry<K, V> deleteEntry(AVLEntry<K, V> p, K key) {
		if (p == null)
			return p;
		int res = compare(key, p.key);
		if (res == 0) {
			// 1 叶子节点 直接删除
			if (p.left == null && p.right == null) {
				p = null;
			} else if (p.left != null && p.right == null) {
				// 2 节点只有 左子树(右子树)
				p = p.left;
			} else if (p.right != null && p.left == null) {
				// 2 节点只有 左子树(右子树)
				p = p.right;
			} else {
				// 3 有两个孩子
				if ((size & 1) == 0) {
					AVLEntry<K, V> rightMin = getFirstEntry(p.right);
					p.key = rightMin.key;
					p.value = rightMin.value;
					AVLEntry<K, V> newRight = deleteEntry(p.right, p.key);
					p.right = newRight;
				} else {
					AVLEntry<K, V> leftMax = getLastEntry(p.left);
					p.key = leftMax.key;
					p.value = leftMax.value;
					AVLEntry<K, V> newLeft = deleteEntry(p.left, p.key);
					p.left = newLeft;
				}
			}

		} else if (res < 0) {
			AVLEntry<K, V> newLeft = deleteEntry(p.left, key);
			p.left = newLeft;
		} else {
			AVLEntry<K, V> newRight = deleteEntry(p.right, key);
			p.right = newRight;
		}
		return p;
	}

	public V remove(K key) {
		AVLEntry<K, V> entry = getEntry(key);
		if (entry == null)
			return null;
		V oldVal = entry.getValue();
		root = deleteEntry(root, key);
		size--;
		return oldVal;
	}

	/**
	 * 层序遍历
	 */
	public void levelOrder() {
		Queue<AVLEntry<K, V>> queue = new LinkedList<>();
		queue.offer(root);
		// 利用这两个变量也是一种算法模板
		int preCount = 1;
		int pCount = 0;
		while (!queue.isEmpty()) {
			preCount--;
			AVLEntry<K, V> p = queue.poll();
			System.out.print(p + " ");
			if (p.left != null) {
				queue.offer(p.left);
				pCount++;
			}
			if (p.right != null) {
				queue.offer(p.right);
				pCount++;
			}
			if (preCount == 0) {
				preCount = pCount;
				pCount = 0;
				System.out.println();// 换行
			}
		}
	}

}
