package com.ja0ck5.bitoperation;

/**
 * 位运算 Created by Jack on 2018/7/30.
 */
public class BitOperation {

	/**
	 * 
	 * 使用位运算判断整数的奇偶性
	 * 
	 * 二进制中
	 * <p>
	 * 1. 如果一个数是偶数那么最后一个一定是 0, 如果一个数是奇数那么最后一位一定是 1;
	 * <p>
	 * 2. 十进制 1 在 8 位二进制中表示为 0000 0001;
	 * <p>
	 * 3. 我们只需将一个数 跟 1相与（&） 得到的结果如果是 1 则表示该数为奇数，否则为偶数
	 */
	public boolean isOdd(int num) {
		return (num & 1) != 0;
	}

	/**
	 * 给定一个整数，使用位运算判断该整数是不是2的整数次幂
	 * 
	 * <p>
	 * 一个二进制如果表示为 0..0100...0，那么它减去1得到的数二进制表示肯定是 0..0011..1 的形式。那么这个数 num 与
	 * (num-1) 后的数相与(&)得到结果肯定为0
	 * </p>
	 * <img src=
	 * "http://w2.dwstatic.com/yy/ojiastoreimage/1076x336/1532915878003_11_len39984.jpg">
	 * 
	 * @param num
	 * @return
	 */
	public boolean isLog2(int num) {
		return (num & (num - 1)) == 0;
	}

	/**
	 * <p>
	 * 
	 * 使用位运算判断该整数的二进制表示中1的个数
	 * </p>
	 * 
	 * 需要考虑符号 对于正数右移和无符号右移得到结果一样，如果是负数，右移操作将在二进制补码左边添加追加1，而无符号右移则是补 0
	 * 
	 * @param num
	 * @return
	 */
	public int count1(int num) {
		int res = 0;
		while (num != 0) {
			res += num & 1;// 存在1 则加上
			num >>>= 1;//
		}
		return res;
	}

	/**
	 * 使用位运算判断该整数的二进制表示中1的个数 减少循环次数 <img src=
	 * "http://w2.dwstatic.com/yy/ojiastoreimage/1280x350/1532916027778_11_len48062.jpg">
	 * 
	 * @param n
	 * @return
	 */
	public int otherCount1(int n) {
		int res = 0;
		while (n != 0) {
			n &= (n - 1);
			res++;
		}
		return res;
	}

}
