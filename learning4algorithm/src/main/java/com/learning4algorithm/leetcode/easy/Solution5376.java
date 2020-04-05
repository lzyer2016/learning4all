package com.learning4algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Minimum Subsequence in Non-Increasing Order
 */
public class Solution5376 {

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ret = new ArrayList<>();
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int temp = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            ret.add(nums[i]);
            sum -= nums[i];
            temp += nums[i];
            if (temp > sum) {
                break;
            }
        }
        return ret;
    }
}
