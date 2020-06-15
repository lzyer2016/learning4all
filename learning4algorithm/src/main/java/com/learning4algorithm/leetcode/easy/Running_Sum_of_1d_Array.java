package com.learning4algorithm.leetcode.easy;

public class Running_Sum_of_1d_Array {

    public int[] runningSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        return sum;
    }
}
