package com.learning4algorithm.leetcode.medium;

public class Count_Triplets {

    public static int countTriplets(int[] arr) {
        if (arr == null) {
            return 0;
        }

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = dp[i - 1] ^ arr[i];
        }
        int size = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j; k < arr.length; k++) {
                    int a = dp[j - 1];
                    int b = dp[k];
                    if (i > 0) {
                        a ^= dp[i - 1];
                    }
                    b ^= dp[j - 1];
                    if (a == b) {
                        size++;
                    }
                }
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int[] arr = {7, 11, 12, 9, 5, 2, 7, 17, 22};
        System.out.println(countTriplets(arr));
    }
}
