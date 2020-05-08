package com.learning4algorithm.leetcode.medium;

public class Find_Minimum_Number_of_Fibonacci_Numbers {

    public int findMinFibonacciNumbers(int k) {
        if (k < 2) {
            return k;
        }
        int a = 1, b = 1;
        while (b <= k) {
            b = b + a;
            a = b - a;
        }
        return 1 + findMinFibonacciNumbers(k - a);
    }
}
