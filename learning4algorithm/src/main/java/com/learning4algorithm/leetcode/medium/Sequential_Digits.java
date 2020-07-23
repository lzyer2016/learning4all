package com.learning4algorithm.leetcode.medium;

import java.util.*;

public class Sequential_Digits {

    public static List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 9; i++) {
            queue.add(i);
        }
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int num = queue.peek();
            queue.remove();
            if (num >= low && num <= high) {
                list.add(num);
            }
            if (num > high)
                break;
            int d = num % 10;
            if (d < 9) {
                queue.add(num * 10 + d + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(sequentialDigits(100, 300));
    }
}
