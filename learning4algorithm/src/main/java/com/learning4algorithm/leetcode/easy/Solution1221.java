package com.learning4algorithm.leetcode.easy;

public class Solution1221 {

    public int balancedStringSplit(String s) {
        if (s == null || s.length() == 1) {
            return 0;
        }
        int lCount = 0, rCount = 0, total = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                lCount++;
            } else {
                rCount++;
            }
            if (lCount == rCount) {
                total++;
            }
        }
        return total;
    }
}
