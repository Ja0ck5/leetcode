package com.ja0ck5.javadeathmatch;

/**
 * @author: Ja0ck5
 * @Description: 大数相乘
 * @Date: Created in 16:29 2018/9/18
 * @Modified By:
 */
public class BigCount {

	public static void main(String[] args) {
		String s1 = "1238926981273989239847892378790123";
		String s2 = "3897023740908947829389837434873492374908907107810149923874";

		int len1 = s1.length();
		int len2 = s2.length();

		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		convertData(c1, len1);
		convertData(c2, len2);

		multiply(c1, len1, c2, len2);

	}

	private static void multiply(char[] c1, int len1, char[] c2, int len2) {
		// 两数乘积位数不会超过乘数位数和+3
		int csize = len1 + len2 + 3;

		int[] c = new int[csize];

		// 对齐逐位相乘
		for (int i = 0; i < len2; i++) {
			for (int j = 0; j < len1; j++) {
				c[i + j] += Integer.parseInt(String.valueOf(c1[j])) * Integer.parseInt(String.valueOf(c2[i]));
			}
		}

		int m = 0;
		// 进位处理
		for (m = 0; m < csize; m++) {
			int carry = c[m] / 10;
			c[m] %= 10;
			if (carry > 0) {
				c[m + 1] += carry;
			}
		}

		// 找到最高位
		for (m = csize - 1; m >= 0; m--) {
			if (c[m] > 0) {
				break;
			}
		}

        for (int i = 0; i <= m; i++) {
            System.out.print(c[m-i]);
        }


	}

	private static void convertData(char[] c, int len) {
		for (int i = 0; i < len / 2; i++) {
			c[i] += c[len - 1 - i];
			c[len - 1 - i] = (char) (c[i] - c[len - 1 - i]);
			c[i] = (char) (c[i] - c[len - 1 - i]);
		}
	}

}
