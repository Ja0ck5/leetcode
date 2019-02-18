package com.ja0ck5.dp;

/**
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 20:12 2019/2/18
 * @Modified By:
 */
public class CoinChange {

	/**
	 * 会有很多重复计算情况
	 *
	 * 将计算结果保存下来，改变计算顺序，以提高效率。使用动态规划
	 * 
	 * @param x
	 * @return
	 */
	public int count(int x) {
		if (x == 0)
			return 0;
		int res = Integer.MAX_VALUE;
		if (x >= 2) {
			res = Math.min(count(x - 2) + 1, res);
		}
		if (x >= 5) {
			res = Math.min(count(x - 5) + 1, res);
		}
		if (x >= 7) {
			res = Math.min(count(x - 7) + 1, res);
		}
		return res;
	}

	public int coinChange(int[] A/* {2,5,7} */, int M/* 27 */) {
		int[] f = new int[M + 1];
		int n = A.length;
		f[0] = 0;
		for (int i = 0; i <= M; i++) {
			f[i] = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				if (i >= A[j] && f[i - A[j]] != Integer.MAX_VALUE)
					f[i] = Math.min(f[i], f[i - A[j]] + 1);
			}
		}
		if (f[M] == Integer.MAX_VALUE)
			f[M] = -1;
		return f[M];
	}

}
