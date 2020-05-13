package com.learning4algorithm.leetcode.medium;

public class Number_of_Sub_arrays_of_Size_K {

    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int ret = 0;
        for (int i = 0; i < arr.length - k + 1; i++) {
            int sum = 0;
            for (int j = i; j < k + i; j++) {
                sum += arr[j];
            }
            System.out.println(sum);
            if (sum / k >= threshold) {
                ret++;
            }
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
