package com.learning4algorithm.leetcode.medium;

public class Teemo_Attacking {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }
        int sum = 0;
        int start = timeSeries[0];
        for (int time : timeSeries) {
            sum = sum + ((time < (start + duration)) ? time - start : duration);
            start = time;
        }
        return sum + duration;
    }
}
