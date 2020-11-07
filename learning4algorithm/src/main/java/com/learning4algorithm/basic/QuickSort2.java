package com.learning4algorithm.basic;

public class QuickSort2 {

    public void quickSort(int[] q, int l, int r) {
        if (l >= r)
            return;
        int x = q[l + r >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            while (q[++i] < x) ;
            while (q[--j] > x) ;
            if (i < j) {
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        quickSort(q, l, j);
        quickSort(q, j + 1, r);
    }

    public static void main(String[] args) {
        QuickSort2 quickSort2 = new QuickSort2();
        int[] q = {1, 7, 2, 3, 9, 25, 0};
        quickSort2.quickSort(q, 0, q.length - 1);
        for (int num : q) {
            System.out.print(num + " ");
        }
    }
}
