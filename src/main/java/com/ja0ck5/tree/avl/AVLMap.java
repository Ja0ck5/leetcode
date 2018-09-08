package com.ja0ck5.tree.avl;

import com.ja0ck5.TreeNode;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. 弹栈的时候，一旦发现某个节点的高度未发生改变，则立即停止回溯 2. 指针回溯次数，最坏O(logN),最好 O(1),平均O(logN) 3.
 * 旋转次数，无需旋转、单旋转、双旋转，不会超过两次，O(1) 4. 时间复杂度: BST 的插入 logN + 指针回溯 logN + 旋转 O(1) =
 * O(logN) 5. 空间复杂度，加上 parent 属性为 O(1),无则 O(logN) 需要额外的栈进行回溯
 *
 * @program: leetcode
 * @description:
 * @author: Ja0ck5
 * @create: 2018-08-01 23:07
 **/
public class AVLMap<K, V> implements Iterable<AVLEntry<K, V>> {

    private int size;
    private AVLEntry<K, V> root;
    private Comparator comp;

    private LinkedList<AVLEntry<K, V>> stack = new LinkedList<>();

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
            stack.push(root);
            size++;
        } else {
            AVLEntry<K, V> p = root;
            while (p != null) {
                stack.push(p);
                int compRes = compare(key, p.key);
                if (compRes == 0) {
                    p.setValue(value);
                    break;
                } else if (compRes < 0) {
                    if (p.left == null) {
                        p.left = new AVLEntry<>(key, value);
                        size++;
                        stack.push(p.left);
                        break;
                    } else {
                        p = p.left;
                    }
                } else {
                    if (p.right == null) {
                        p.right = new AVLEntry<>(key, value);
                        size++;
                        stack.push(p.right);
                        break;
                    } else {
                        p = p.right;
                    }
                }
            }
        }
        fixAfterInsertion(key);
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
     * @param p   在子树 P 中删除 key
     * @param key
     * @return
     */
    private AVLEntry<K, V> deleteEntry(AVLEntry<K, V> p, K key) {
        if (p == null) {
            return p;
        }
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
        fixAfterDeletion(p);
        return p;
    }

    private void fixAfterInsertion(K key) {
        AVLEntry<K, V> p = root;
        while (!stack.isEmpty()) {
            p = stack.pop();
            int newHeight = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
            if (p.height > 1 && newHeight == p.height) {
                stack.clear();
                return;
            }
            p.height = newHeight;
            int d = getHeight(p.left) - getHeight(p.right);
            if (Math.abs(d) <= 1) {
                continue;
            } else {
                if (d == 2) {
                    if (compare(key, p.left.key) < 0) {
                        p = rotateRight(p);
                    } else {
                        p = firstLeftThenRight(p);
                    }
                } else {
                    if (compare(key, p.right.key) > 0) {
                        p = rotateLeft(p);
                    } else {
                        p = firstRightThenLeft(p);
                    }
                }
                if (!stack.isEmpty()) {
                    if (compare(key, stack.peek().key) < 0) {
                        stack.peek().left = p;
                    } else {
                        stack.peek().right = p;
                    }
                }
            }
        }
        root = p;
    }

    public void checkBalance() {
        // 借助于 后序遍历
        postOrderCheckBalance(root);
    }

    private boolean postOrderCheckBalance(AVLEntry<K, V> p) {
        boolean flag = false;
        if (p != null) {
            postOrderCheckBalance(p.left);
            postOrderCheckBalance(p.right);
            if (Math.abs(getHeight(p.left) - getHeight(p.right)) <= 1) {
                flag = true;
            }
        }
        return flag;
    }

    public V remove(K key) {
        AVLEntry<K, V> entry = getEntry(key);
        if (entry == null) {
            return null;
        }
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

    /**
     * 寻找后继节点
     *
     * @param t
     * @return
     */
    public AVLEntry<K, V> successor(AVLEntry<K, V> t) {
        if (t == null) {
            return null;
        }

        // case 1: 有右子树的情况 和 getFirstEntry 完全一致
        if (t.right != null) {
            AVLEntry<K, V> p = t.right;
            // 找到右子树最小节点，即 右子树最左边的节点
            while (p.left != null) {
                p = p.left;
            }
            return p;
        } else {
            // case 2: 没有用右子树，向上回溯，找到第一个孩子是左子树,后继节点为该孩子的父亲
            AVLEntry<K, V> p = t.parent;
            AVLEntry<K, V> ch = t;
            // 找到第一个 孩子是最孩子的父亲节点，或者根节点
            while (p != null && ch == p.right) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }

    public AVLEntry<K, V> rotateRight(AVLEntry<K, V> p) {
        AVLEntry<K, V> left = p.left;
        p.left = left.right;
        left.right = p;
        p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
        left.height = Math.max(getHeight(left.left), getHeight(left.right)) + 1;
        return left;
    }

    public AVLEntry<K, V> rotateLeft(AVLEntry<K, V> p) {
        AVLEntry<K, V> right = p.right;
        p.right = right.left;
        right.left = p;
        p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
        right.height = Math.max(getHeight(right.left), getHeight(right.right)) + 1;
        return right;
    }

    public AVLEntry<K, V> firstLeftThenRight(AVLEntry<K, V> p) {
        // left child rotateLeft
        p.left = rotateLeft(p.left);
        // the node itself rotateRight
        p = rotateRight(p);
        return p;
    }

    public AVLEntry<K, V> firstRightThenLeft(AVLEntry<K, V> p) {
        // right child rotateRight
        p.right = rotateRight(p.right);
        // the node itself rotateLeft
        p = rotateLeft(p);
        return p;
    }

    public int getHeight(AVLEntry<K, V> p) {
        return p == null ? 0 : p.height;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildFromSorted(0, nums.length - 1, nums);
    }

    public TreeNode buildFromSorted(int lo, int hi, int[] nums) {
        if (hi < lo) {
            return null;
        }
        int mid = (lo + hi) >>> 1;
        TreeNode left = null;
        if (lo < mid) {
            left = buildFromSorted(lo, mid - 1, nums);
        }
        TreeNode middle = new TreeNode(nums[mid]);
        if (left != null) {
            middle.left = left;
        }
        if (mid < hi) {
            TreeNode right = buildFromSorted(mid + 1, hi, nums);
            middle.right = right;
        }
        return middle;
    }

    public AVLEntry<K, V> fixAfterDeletion(AVLEntry<K, V> p) {
        if (null == p) {
            return null;
        }
        p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
        int d = getHeight(p.left) - getHeight(p.right);
        if (d == 2) {
            if (getHeight(p.left.left) - getHeight(p.left.right) >= 0) {
                p = rotateRight(p);
            } else {
                p = firstLeftThenRight(p);
            }
        } else if (d == -2) {
            if (getHeight(p.right.right) - getHeight(p.right.left) >= 0) {
                p = rotateLeft(p);
            } else {
                p = firstRightThenLeft(p);
            }
        }
        return p;
    }
}
