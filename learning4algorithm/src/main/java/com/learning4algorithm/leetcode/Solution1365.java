package com.learning4algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1365 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int[] clone = nums.clone();
        Arrays.sort(clone);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < clone.length; i++) {
            map.putIfAbsent(clone[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            clone[i] = map.get(nums[i]);
        }
        return clone;
    }
}
