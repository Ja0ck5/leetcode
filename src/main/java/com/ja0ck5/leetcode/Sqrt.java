package com.ja0ck5.leetcode;

/**
 *
 * 69. Sqrt(x)
 * Easy
 *
 * 695
 *
 * 1272
 *
 * Favorite
 *
 * Share
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 10:22 2019/4/8
 * @Modified By:
 */
public class Sqrt {

    public int mySqrt(int x) {
        if(x <= 0) return 0;
        int lo = 1;
        int hi = x;
        while(lo <= hi){
            long mid = (hi - lo) / 2 + lo;
            if(mid * mid == x){
                return (int)mid;
            }else if(mid * mid < x){
                lo =(int) mid + 1;
            }else{
                hi = (int)mid - 1;
            }
        }
        if(hi * hi < x){
            return hi;
        }else{
            return lo;
        }
    }

}
