package com.learning4algorithm.basic;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class HeapSort {

    public void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 保持大根堆的状态 O(N*logN)
        /*for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }*/

        // O(N) 变成一个大根堆
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    // 比较左右节点做下沉操作
    public void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index)
                break;
            swap(arr, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }

    public void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public void swap(int[] arr, int index, int parentIndex) {
        int temp = arr[index];
        arr[index] = arr[parentIndex];
        arr[parentIndex] = temp;
    }

    public static void main(String[] args) {
        int length = 10;
        int max = 100;
        boolean success = true;
        HeapSort heapSort = new HeapSort();
        for (int i = 0; i < 5000; i++) {
            int[] arr = generateRandomData(length, max);
            int[] arr1 = copyArray(arr);
            heapSort.heapSort(arr);
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
