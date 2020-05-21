package com.learning4algorithm.leetcode.medium;

public class Grumpy_Bookstore {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int noGrumpCustomer = 0;
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) {
                noGrumpCustomer += customers[i];
            }
        }
        int windowSum = 0;
        int noGrumpSum = 0;
        int i;
        for (i = 0; i < X; i++) {
            windowSum += customers[i];
            if (grumpy[i] == 0) {
                noGrumpSum += customers[i];
            }
        }
        int max = windowSum + (noGrumpCustomer - noGrumpSum);
        for (int j = X; j < grumpy.length; j++) {
            windowSum -= customers[j - X];
            windowSum += customers[j];
            if (grumpy[j - X] == 0) {
                noGrumpSum -= customers[j - X];
            }
            if (grumpy[j] == 0) {
                noGrumpSum += customers[j];
            }
            max = Math.max(max, windowSum + (noGrumpCustomer - noGrumpSum));
        }
        return max;
    }
}
