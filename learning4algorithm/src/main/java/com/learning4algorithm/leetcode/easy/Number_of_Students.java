package com.learning4algorithm.leetcode.easy;

public class Number_of_Students {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        if (startTime == null || startTime.length == 0) {
            return 0;
        }
        int res = 0;
        int len = startTime.length;
        for (int i = 0; i < len; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                res++;
            }
        }
        return res;
    }
}
