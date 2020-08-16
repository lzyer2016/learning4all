package com.learning4algorithm.leetcode.medium;

public class LeetCode_1551 {

    public int minOperations(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (2 * i) + 1;
        }
        int res = 0;
        if ((n & 1) == 1) {
            int mid = n / 2;
            for (int i = 0; i < mid; i++) {
                res += arr[mid] - arr[i];
            }
        } else {
            int mid = n / 2;
            int midValue = (arr[mid] + arr[mid - 1]) / 2;
            for (int i = 0; i < mid; i++) {
                res += midValue - arr[i];
            }
        }
        return res;
    }
}
