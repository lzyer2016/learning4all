package com.learning4algorithm.leetcode;

/**
 * 1342. Number of Steps to Reduce a Number to Zero
 */
public class Solution1342 {
    public int numberOfSteps(int num) {
        if (num == 0) {
            return 0;
        }
        int step = 0;
        while (num != 0) {
            if ((num & 1) == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            step++;
        }
        return step;
    }
}
