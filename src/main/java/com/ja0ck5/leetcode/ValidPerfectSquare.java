package com.ja0ck5.leetcode;

/**
 *
 * 367. Valid Perfect Square
 * Easy
 *
 * 421
 *
 * 97
 *
 * Favorite
 *
 * Share
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 14
 * Output: false
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 11:05 2019/4/18
 * @Modified By:
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if(num < 0){
            return false;
        }
        long r = num;
        long l = 0;
        long mid, t;
        while(l <= r){
            mid = (r - l) / 2 + l;
            t = mid*mid;
            if(t == num){
                return true;
            }else if(t < num){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return false;
    }


}
