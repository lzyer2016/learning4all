package com.learning4algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1346. Check If N and Its Double Exist
 */
public class Solution1346 {

    public static boolean checkIfExist(int[] arr) {
        if (arr == null)
            return false;
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i] * 2, i);
        }

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]) && map.get(arr[i]) != i) {
                return true;
            }
        }
        return false;
    }
}
