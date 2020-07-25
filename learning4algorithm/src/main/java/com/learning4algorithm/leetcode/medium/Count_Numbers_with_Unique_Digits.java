package com.learning4algorithm.leetcode.medium;

public class Count_Numbers_with_Unique_Digits {

    public int countNumbersWithUniqueDigits(int n) {
        if (n > 10) {
            return countNumbersWithUniqueDigits(10);
        }
        int count = 1;
        long max = (long) Math.pow(10, n);
        boolean[] used = new boolean[10];
        for (int i = 1; i <= 9; i++) {
            used[i] = true;
            count += help(i, used, max);
            used[i] = false;
        }
        return count;
    }

    public int help(long cur, boolean[] used, long max) {
        int count = 0;
        if (cur < max) {
            count++;
        } else {
            return count;
        }
        for (int i = 0; i < 10; i++) {
            if (!used[i]) {
                used[i] = true;
                long temp = cur * 10 + i;
                count += help(temp, used, max);
            }
        }
        return count;
    }
}
