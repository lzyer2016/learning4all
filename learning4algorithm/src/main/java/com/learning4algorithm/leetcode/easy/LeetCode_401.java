package com.learning4algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_401 {

    public List<String> readBinaryWatch(int num) {
        if (num < 0 || num > 10) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        for (int hour = 0; hour <= 11; hour++) {
            for (int minute = 0; minute <= 59; minute++) {
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == num) {
                    res.add(String.format("%d:%02d", hour, minute));
                }
            }
        }
        return res;
    }
}
