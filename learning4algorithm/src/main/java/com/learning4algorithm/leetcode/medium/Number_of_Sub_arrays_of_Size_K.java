package com.learning4algorithm.leetcode.medium;

public class Number_of_Sub_arrays_of_Size_K {

    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int ret = 0;
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < k - 1; i++) {
            sum += arr[i];
        }
        for (int i = k - 1; i < n; i++) {
            sum += arr[i];
            if (sum / k > threshold) {
                ret++;
            }
            sum -= arr[i - k + 1];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;
        System.out.println(numOfSubarrays(arr, k, threshold));
    }
}
