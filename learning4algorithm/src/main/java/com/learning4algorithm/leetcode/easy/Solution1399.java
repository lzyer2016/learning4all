package com.learning4algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1399. Count Largest Group
 */
public class Solution1399 {

    public int countLargestGroup(int n) {
        if (n == 1) {
            return 1;
        }
        Map<Integer, List<Integer>> dict = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int sum = sum(i);
            if (dict.containsKey(sum)) {
                dict.get(sum).add(i);
            } else {
                List<Integer> nums = new ArrayList<>();
                nums.add(i);
                dict.put(sum, nums);
            }
        }
        int count = 0;
        int size = 0;
        for (Map.Entry<Integer, List<Integer>> entry : dict.entrySet()) {
            if (entry.getValue().size() > size) {
                size = entry.getValue().size();
                count = 0;
            }
            if (entry.getValue().size() == size) {
                count++;
            }
        }
        return count;
    }

    public int sum(int num) {
        int sum = 0;
        while (num != 0) {
            int x = num % 10;
            sum += x;
            num /= 10;
        }
        return sum;
    }
}
