package com.learning4algorithm.leetcode.easy;

public class LeetCode_5185 {

    public boolean threeConsecutiveOdds(int[] arr) {
        int res = 0;
        for (int num : arr) {
            if ((num & 1) == 1) {
                res++;
                if (res == 3) {
                    return true;
                }
            } else {
                res = 0;
            }
        }
        return false;
    }
}
