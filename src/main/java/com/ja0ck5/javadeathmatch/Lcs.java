package com.ja0ck5.javadeathmatch;

/**
 * 最长公共子序列
 *
 * 根据公式 if string a.length == 0 or string b.length == 0 return 0 if a[i] == b[i]
 * then lcs = C[i-1][j-1]+1 if a[i] != b[i] then lcs = Max{C[i][j-1],C[i-1][j]}
 * 
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 9:36 2018/9/11
 * @Modified By:
 */
public class Lcs {

	public static int findLCS(String a, String b) {
		if (a == null || b == null || a.length() == 0 || b.length() == 0) {
			return 0;
		}
		int n = a.length();
		int m = b.length();
		int[][] dp = new int[n][m];
		char[] aArr = a.toCharArray();
		char[] bArr = b.toCharArray();
		// 判断第一列
		for (int i = 0; i < n; i++) {
			if (aArr[i] == bArr[0]) {
				dp[i][0] = 1;
				for (int j = i + 1; j < n; j++) {
					dp[j][0] = 1;
				}
				break;
			}
		}

		// 判断第一行
		for (int i = 0; i < m; i++) {
  			if (bArr[i] == aArr[0]) {
				dp[0][i] = 1;
				for (int j = i + 1; j < m; j++) {
					dp[0][j] = 1;
				}
				break;
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (aArr[i] == bArr[j]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[n - 1][m - 1];
	}

	public static void main(String[] args) {
		String a = "random";
		String b = "kkkkkkandroidlllllllllll";
		int lcs = findLCS(a, b);
		System.out.println(lcs);
	}

}
