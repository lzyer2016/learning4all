package com.learning4algorithm.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_5471 {


    public int maxNonOverlapping(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, availableIndex = -1, ans = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int remain = prefixSum - target;
            if (map.containsKey(remain) && map.get(remain) >= availableIndex) {
                ans++;
                availableIndex = i;
            }
            map.put(prefixSum, i);
        }
        return ans;
    }
}
