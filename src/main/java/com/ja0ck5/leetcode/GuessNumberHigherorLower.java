package com.ja0ck5.leetcode;

/**
 * 374. Guess Number Higher or Lower
 * Easy
 *
 * 211
 *
 * 1082
 *
 * Favorite
 *
 * Share
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 *
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 *
 * -1 : My number is lower
 *  1 : My number is higher
 *  0 : Congrats! You got it!
 * Example :
 *
 * Input: n = 10, pick = 6
 * Output: 6
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 11:46 2019/4/18
 * @Modified By:
 */
public class GuessNumberHigherorLower {



    /* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */
    public int guessNumber(int n) {
        if(0 == guess(n)) return n;
        int start = 1,end = n ;
        int mid,res;
        while(start < end){
            mid = (end - start)/2 + start;
            res = guess(mid);
            if(0 == res){
                return mid;
            }else if(1 == res){
                start = mid;
            }else{
                end = mid;
            }
        }
        return -1;
    }

    private int guess(int n) {
        int num = 6;
        if(n == num) return 0;
        if(n < num) return -1;
        return 1;
    }

}
