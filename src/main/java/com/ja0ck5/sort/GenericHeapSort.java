package com.ja0ck5.sort;

import java.util.Comparator;

/**
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 13:33 2018/10/15
 * @Modified By:
 */
public class GenericHeapSort<T> {

	private Comparator<T> comp;

	public int compare(T a, T b) {
		if (comp != null) {
			return comp.compare(a, b);
		} else {
			Comparable<T> c = (Comparable<T>) a;
			return c.compareTo(b);
		}
	}

	private void swap(T[] array, int a, int b) {
		T t = array[a];
		array[a] = array[b];
		array[b] = t;
	}

	/**
	 * 2*i +2 右孩子 2*i +1 左孩子
	 * 
	 * @param array
	 * @param p
	 *            需要调整的元素的下标
	 * @param heapSize
	 *            堆的大小
	 */
	private void siftDown(T[] array, int p, int heapSize) {
		T val = array[p];
		int child;// 孩子节点的下标
		while ((child = (p << 1) + 1) <= heapSize) {
			// child + 1 表示有右孩子，并选出较大的孩子节点
			if (child + 1 <= heapSize) {
				child = compare(array[child], array[child + 1]) >= 0 ? child : child + 1;
			}
			// 比较 val 与较大孩子节点的值的大小
			if (compare(val, array[child]) >= 0) {
				break;
			}
			// 否则进行指针移动
			array[p] = array[child];
			p = child;
		}
		array[p] = val;
	}

	/**
	 *
	 * @param array
	 * @param p
	 *            需要调整的元素的下标，即需要处理的子树的根节点
	 * @param lastIndex
	 *            第一个非叶子节点
	 * @param heapSize
	 *            堆的大小
	 */
	private void heapifyPostOrder(T[] array, int p, int lastIndex, int heapSize) {
		if (p <= lastIndex) {
			heapifyPostOrder(array, (p << 1) + 2, lastIndex, heapSize);
			heapifyPostOrder(array, (p << 1) + 1, lastIndex, heapSize);
			siftDown(array, p, heapSize);
		}
	}

	public void heapSort(T[] array) {
		int len = array.length;
		heapifyPostOrder(array, 0, len >>> 1, len - 1);
		for (int i = len - 1; i > 0; i--) {
			swap(array, 0, i);
			siftDown(array, 0, i - 1);
		}
	}

}
