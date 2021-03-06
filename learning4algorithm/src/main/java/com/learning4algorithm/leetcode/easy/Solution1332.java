package com.learning4algorithm.leetcode.easy;

/**
 * 1332. Remove Palindromic Subsequences
 */
public class Solution1332 {
    public int removePalindromeSub(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return 2;
            }
        }
        return 1;
    }
}
