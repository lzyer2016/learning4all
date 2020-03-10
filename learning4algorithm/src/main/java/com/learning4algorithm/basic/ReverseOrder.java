package com.learning4algorithm.basic;

/**
 * 逆序对问题
 */
public class ReverseOrder {

    public static int reverseOrder(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return process(arr, L, mid) + process(arr, mid + 1, R) + merge(arr, L, mid, R);
    }

    public static int merge(int[] arr, int L, int m, int R) {
        int ret = 0;
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = m + 1;
        int i = 0;
        while (p1 <= m && p2 <= R) {
            // p2 比 p1以及p1后面的数都要小
            ret += arr[p2] < arr[p1] ? (m - p1 + 1) : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(reverseOrder(arr));
        // output: 7
    }
}
