package com.learning4algorithm.basic;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {

    void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    void process(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int[] p = partition(arr, L, R);
            process(arr, 0, p[0] - 1);
            process(arr, p[1] + 1, R);
        }
    }

    int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, L++, ++less);
            } else if (arr[L] > arr[R]) {
                swap(arr, L, --more);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    void swap(int[] arr, int index, int R) {
        int temp = arr[index];
        arr[index] = arr[R];
        arr[R] = temp;
    }

    public static void main(String[] args) {
        int length = 10;
        int max = 100;
        boolean success = true;
        QuickSort quickSort = new QuickSort();
        for (int i = 0; i < 5000; i++) {
            int[] arr = generateRandomData(length, max);
            int[] arr1 = copyArray(arr);
            quickSort.quickSort(arr);
            Arrays.sort(arr1);
            if (!isEqual(arr, arr1)) {
                success = false;
                printArr(arr);
                printArr(arr1);
                break;
            }
        }
        if (success) {
            System.out.println("Success!");
        } else {
            System.out.println("Failed!");
        }
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static boolean isEqual(int[] arr, int[] arr1) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr1[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] copyArray(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public static int[] generateRandomData(int length, int max) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(max);
        }
        return arr;
    }
}
