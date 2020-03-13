package com.learning4algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution1356 {

    public int[] sortByBits(int[] arr) {
        if (arr == null)
            return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], bitOne(arr[i]));
        }
        int j = 1;
        while (j < arr.length) {
            int p = j;
            while (p > 0) {
                boolean flag = map.get(arr[p]) < map.get(arr[p - 1]) ||
                        ((map.get(arr[p]).equals(map.get(arr[p - 1]))) && arr[p] < arr[p - 1]);
                if (flag) {
                    int temp = arr[p];
                    arr[p] = arr[p - 1];
                    arr[p - 1] = temp;
                }
                p--;
            }
            j++;
        }
        return arr;
    }

    public int bitOne(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >> 1;
        }
        return count;
    }
}
