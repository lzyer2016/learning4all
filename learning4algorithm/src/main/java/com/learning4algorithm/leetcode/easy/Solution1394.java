package com.learning4algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Solution1394 {
    public int findLucky(int[] arr) {
        if (arr == null) {
            return -1;
        }
        Map<Integer, Integer> dict = new HashMap<>();
        int ans = -1;
        for (int i = 0; i < arr.length; i++) {
            if (dict.containsKey(arr[i])) {
                dict.put(arr[i], dict.get(arr[i]) + 1);
            } else {
                dict.put(arr[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : dict.entrySet()) {
            if (entry.getValue().equals(entry.getKey())) {
                ans = entry.getKey();
            }
        }
        return ans;
    }
}
