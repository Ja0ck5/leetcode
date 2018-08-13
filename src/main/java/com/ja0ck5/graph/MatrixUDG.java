package com.ja0ck5.graph;

/**
 * @program: leetcode
 * @description: 邻接矩阵
 * @author: Ja0ck5
 * @create: 2018-08-10 00:07
 **/
public class MatrixUDG {

	/**
	 * // 顶点集合
	 */
	private char[] mVexs;
	/**
	 * 邻接矩阵
	 * mMatrix[i][j]=1，则表示"顶点i(即mVexs[i])"和"顶点j(即mVexs[j])"是邻接点；mMatrix[i][j]=0，则表示它们不是邻接点。
	 */
	private int[][] mMatrix;

	private static final int INF = Integer.MAX_VALUE; // 最大值

	public char[] getmVexs() {
		return mVexs;
	}

	public void setmVexs(char[] mVexs) {
		this.mVexs = mVexs;
	}

	public int[][] getmMatrix() {
		return mMatrix;
	}

	public void setmMatrix(int[][] mMatrix) {
		this.mMatrix = mMatrix;
	}

	/**
	 * prim最小生成树 普里姆(Prim)算法，是用来求加权连通图的最小生成树的算法。
	 * 
	 * 基本思想 对于图G而言，V是所有顶点的集合；现在，设置两个新的集合U和T，其中U用于存放G的最小生成树中的顶点，T存放G的最小生成树中的边。
	 * 从所有uЄU，vЄ(V-U) (V-U表示出去U的所有顶点)的边中选取权值最小的边(u, v)，将顶点v加入集合U中，将边(u,
	 * v)加入集合T中，如此不断重复，直到U=V为止，最小生成树构造完毕，这时集合T中包含了最小生成树中的所有边。
	 * 
	 * @param start
	 *            从图中的第start个元素开始，生成最小树
	 */
	public void prim(int start) {
		// 顶点个数
		int num = mVexs.length;
		// 最小生成树的索引,即 prims 数组的索引
		int index = 0;
		/**
		 * U 存放图的最小生成树的顶点
		 */
		char[] uPrims = new char[num];

		/**
		 * 顶点之间的边的权值
		 */
		int[] weights = new int[num];

		// uPrims 最小生成树中的第一个数是 图中第 start 个顶点
		uPrims[index++] = mVexs[start];

		// 初始化 "顶点的权值数组"
		// 将每个顶点的权值初始化为 " 第 start 个顶点" 到 "该顶点的权值"
		for (int i = 0; i < num; i++) {
			weights[i] = mMatrix[start][i];
		}

		// 将第start个顶点的权值初始化为0，因为 到自身的距离为 0
		weights[start] = 0;

		for (int i = 0; i < num; i++) {

			if (start == i) {
				// 由 start 开始，因此不需要对 第 start 个顶点进行处理
				continue;
			}

			int j = 0, k = 0, min = INF;
			// 在未被加入到最小生成树的顶点中，找出权值最小的顶点
			while (j < num) {
				// 若 weights[j] = 0,意味着 第j个节点已经被排序过(即已经你加入了最小生成树中)
				if (weights[j] != 0 && weights[j] < min) {
					min = weights[j];
					k = j;
				}
				j++;
			}

			// 在未被加入到最小生成树的顶点中，权值最小的顶点是第K个顶点
			// 将 第 K 个顶点加入到最小生成树的数组中
			uPrims[index++] = mVexs[k];

			// 将 第 K 个顶点的权值标记为 0,,意味着已经加入了 最小生成树中
			weights[k] = 0;
			// 当 第 K 个顶点被加入到 最小生成树的 数组中之后，更新其它顶点的权值
			for (int p = 0; p < num; p++) {
				// 当第 p 个节点没有被处理，并且需要更新时才被更新
				if (weights[p] != 0 && mMatrix[k][p] < weights[p]) {
					weights[p] = mMatrix[k][p];
				}
			}
		}
		// 计算最小生成树的权值


	}
}
