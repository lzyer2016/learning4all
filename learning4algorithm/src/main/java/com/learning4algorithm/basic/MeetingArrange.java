package com.learning4algorithm.basic;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 会议安排
 */
public class MeetingArrange {

    static class Meeting {

        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int bestArrange(Meeting[] meetings, int timePoint) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a.end));
        int result = 0;
        for (int i = 0; i < meetings.length; i++) {
            if (timePoint <= meetings[i].start) {
                result++;
                timePoint = meetings[i].end;
            }
        }
        return result;
    }
}
