package com.learning4algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * 1313. Decompress Run-Length Encoded List
 */
public class Solution1313 {
    public int[] decompressRLElist(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i += 2) {
            len += nums[i];
        }
        int[] ret = new int[len];
        int index = 0;
        for (int i = 0; i < nums.length; i += 2) {
            Arrays.fill(ret, index, index + nums[i], nums[i + 1]);
            index = index + nums[i];
        }
        return ret;
    }
}
