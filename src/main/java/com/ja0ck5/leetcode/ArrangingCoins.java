package com.ja0ck5.leetcode;

/**
 * 441. Arranging Coins
 * Easy
 *
 * 190
 *
 * 449
 *
 * Favorite
 *
 * Share
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 *
 * Given n, find the total number of full staircase rows that can be formed.
 *
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 *
 * Example 1:
 *
 * n = 5
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 *
 * Because the 3rd row is incomplete, we return 2.
 * Example 2:
 *
 * n = 8
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 *
 * Because the 4th row is incomplete, we return 3.
 */
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        if( n <= 1) return 1;
        long lo = 1, hi = n,mid;
        while(lo < hi){
            mid = lo + (hi - lo) / 2;
            if( (mid * (mid + 1) / 2) <= n ){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return (int)lo - 1;
    }
}
