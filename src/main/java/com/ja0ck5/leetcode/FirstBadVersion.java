package com.ja0ck5.leetcode;

/**
 * You are a product manager and currently leading a team to develop a new
 * product. Unfortunately, the latest version of your product fails the quality
 * check. Since each version is developed based on the previous version, all the
 * versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first
 * bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether
 * version is bad. Implement a function to find the first bad version. You
 * should minimize the number of calls to the API.
 *
 * Example:
 *
 * Given n = 5, and version = 4 is the first bad version.
 *
 * call isBadVersion(3) -> false call isBadVersion(5) -> true call
 * isBadVersion(4) -> true
 *
 * Then 4 is the first bad version.
 *
 * @author: Ja0ck5A
 * @Description:
 * @Date: Created in 17:26 2018/12/28
 * @Modified By:
 */
public class FirstBadVersion {

	/**
	 * You are given an API bool isBadVersion(version)
	 * 
	 * @param n
	 * @return
	 */
	public boolean isBadVersion(int n) {
		return true;
	}

	public int firstBadVersion(int n) {
		int left = 1, right = n;
		while (left < right) {
			int mid = (left + right) >>> 1;
			if (isBadVersion(mid)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

}
