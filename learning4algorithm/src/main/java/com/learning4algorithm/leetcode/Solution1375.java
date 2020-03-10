package com.learning4algorithm.leetcode;

public class Solution1375 {

    public int numTimesAllBlue(int[] light) {
        int max = 0, ant = 0;
        for (int i = 0; i < light.length; i++) {
            max = Math.max(light[i], max);
            if (max == i + 1) {
                ant++;
            }
        }
        return ant;
    }
}
