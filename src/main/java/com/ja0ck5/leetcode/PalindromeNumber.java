package com.ja0ck5.leetcode;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * <p>
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * <p>
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer",
 * you know that the reversed integer might overflow. How would you handle such case?
 * <p>
 * There is a more generic way of solving this problem.
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int palid = x;
        int rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return palid == rev;
    }

}
