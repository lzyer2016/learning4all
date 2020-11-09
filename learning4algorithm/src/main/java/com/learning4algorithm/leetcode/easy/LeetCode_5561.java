package com.learning4algorithm.leetcode.easy;

import java.util.*;

public class LeetCode_5561 {

    public int getMaximumGenerated(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 2; i <= n; i++) {
            if ((i & 1) == 0) {
                nums[i] = nums[i / 2];
            } else {
                nums[i] = nums[i / 2] + nums[(i / 2) + 1];
            }
            max = Math.max(nums[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode_5561 lc = new LeetCode_5561();
        System.out.println(lc.getMaximumGenerated(7));
    }
}
