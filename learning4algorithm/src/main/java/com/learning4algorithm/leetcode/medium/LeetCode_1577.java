package com.learning4algorithm.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1577 {

    public int numTriplets(int[] nums1, int[] nums2) {
        return work(nums1, nums2) + work(nums2, nums1);
    }

    public int work(int[] a, int[] b) {
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            long key = (long) a[i] * a[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int ans = 0;
        for (int j = 0; j < b.length; j++) {
            for (int k = j + 1; k < b.length; k++) {
                long key = (long) b[j] * b[k];
                ans += map.getOrDefault(key, 0);
            }
        }
        return ans;
    }
}
