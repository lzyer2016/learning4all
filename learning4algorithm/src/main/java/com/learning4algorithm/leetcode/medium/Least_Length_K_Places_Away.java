package com.learning4algorithm.leetcode.medium;

public class Least_Length_K_Places_Away {

    public boolean kLengthApart(int[] nums, int k) {
        int position = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                position = i;
                break;
            }
        }
        for (int i = position + 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (i - position < k) {
                    return false;
                } else {
                    position = i;
                }
            }
        }
        return true;
    }
}
