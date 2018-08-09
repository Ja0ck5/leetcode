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

    private static final int INF = Integer.MAX_VALUE;   // 最大值

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
}
