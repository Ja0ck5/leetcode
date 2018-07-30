package com.ja0ck5.bitoperation;

import java.util.Arrays;

/**
 * 1. 原码 原码就是符号位加上真值的绝对值, 即用第一位表示符号, 其余位表示值. 比如如果是8位二进制:
 * 
 * [+1]原 = 0000 0001
 * 
 * [-1]原 = 1000 0001
 * 
 * 第一位是符号位. 因为第一位是符号位, 所以8位二进制数的取值范围就是:
 * 
 * [1111 1111 , 0111 1111]
 * 
 * 即
 * 
 * [-127 , 127]
 * 
 * 原码是人脑最容易理解和计算的表示方式.
 * 
 * 2. 反码 反码的表示方法是:
 * 
 * 正数的反码是其本身
 * 
 * 负数的反码是在其原码的基础上, 符号位不变，其余各个位取反.
 * 
 * [+1] = [00000001]原 = [00000001]反
 * 
 * [-1] = [10000001]原 = [11111110]反
 * 
 * 可见如果一个反码表示的是负数, 人脑无法直观的看出来它的数值. 通常要将其转换成原码再计算.
 * 
 * 3. 补码 补码的表示方法是:
 * 
 * 正数的补码就是其本身
 * 
 * 负数的补码是在其原码的基础上, 符号位不变, 其余各位取反, 最后+1. (即在反码的基础上+1)
 * 
 * [+1] = [00000001]原 = [00000001]反 = [00000001]补
 * 
 * [-1] = [10000001]原 = [11111110]反 = [11111111]补
 * 
 * 对于负数, 补码表示方式也是人脑无法直观看出其数值的. 通常也需要转换成原码在计算其数值. 位运算 Created by Jack on
 * 2018/7/30.
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

	/**
	 * 在其他数都出现两次的数组中找到只出现一次的数
	 *
	 * 考虑异或的性质
	 * <p>
	 * 任何整数 n 与 0 异或总等于其本身 n，一个数与其本身异或 结果肯定是 0。
	 * <p>
	 * 多个数异或操作，遵循交换律和结合律。
	 */
	public int oddTimesNum(int[] nums) {
		int res = 0;
		for (int num : nums) {
			res ^= num;
		}
		return res;
	}

	/**
	 * <p>
	 * 在其他数都出现两次的数组中找到只出现一次的 两个 数 <img src=
	 * </p>
	 * 任何不相同的两个除了跟自己异或外，不可能每一个位都相同, 不相同的两个数 a b 异或得到结果二进制表示上肯定有一位为 1
	 * "http://w2.dwstatic.com/yy/ojiastoreimage/1004x960/1532922356246_11_len119656.jpg">
	 * 
	 * @param nums
	 * @return
	 */
	public int[] oddTimesNums(int[] nums) {

		int[] res = new int[2];
		int i = 0, j = 0;
		for (int n : nums) {
			i ^= n;
		}
		// 与本身补码相与.设置 rightOne 第 k 位 为 1，其余位为 0
		int rightOne = i & (~i + 1);
		for (int n : nums) {
			// 相与等于 0 则代表了这个数肯定是两个数中第 k 位不为 1 的那个
			if ((rightOne & n) != 0) {
				j ^= n;
			}
		}
		res[0] = j;
		res[1] = j ^ i;
		return res;
	}

	public static void main(String[] args) {
		BitOperation bo = new BitOperation();
		int[] nums = { 1, 2, 3, 4, 1, 2, 3, 5 };
		int[] res = bo.oddTimesNums(nums);
		System.out.println(Arrays.toString(res));
	}

}
