package com.learning4algorithm.leetcode.medium;

import java.util.*;

public class Least_Number_of_Unique_Integers_after_K_Removals {

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values);
        int length = values.size();
        for (int value : values) {
            if (value <= k) {
                k -= value;
                length--;
            } else {
                break;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] arr = {5, 5, 4};
        int k = 1;
        System.out.println(findLeastNumOfUniqueInts(arr, k));
    }
}
