package com.learning4algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Beautiful_Arrangement {

    public static int[] constructArray(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1, j = n; i <= j; ) {
            if (k > 1) {
                list.add((k-- % 2 == 0) ? j-- : i++);
            } else {
                list.add(i++);
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        constructArray(3, 2);
    }
}
