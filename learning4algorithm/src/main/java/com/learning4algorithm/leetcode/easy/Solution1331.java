package com.learning4algorithm.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1331. Rank Transform of an Array
 */
public class Solution1331 {

    public int[] arrayRankTransform(int[] arr) {
        if (arr == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] clone = new int[arr.length];
        for (int i = 0; i < clone.length; i++) {
            clone[i] = arr[i];
        }
        Arrays.sort(clone);
        int rank = 1;
        for (int i = 0; i < clone.length; i++) {
            if (!map.keySet().contains(clone[i])) {
                map.put(clone[i], rank++);
            }
        }
        int[] ret = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ret[i] = map.get(arr[i]);
        }
        return ret;
    }
}
