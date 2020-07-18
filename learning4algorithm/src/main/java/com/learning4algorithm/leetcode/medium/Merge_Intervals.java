package com.learning4algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge_Intervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            boolean flag = false;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j)[1] >= intervals[i][0]) {
                    int max = Math.max(list.get(j)[1], intervals[i][1]);
                    list.get(j)[1] = max;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                list.add(intervals[i]);
            }
        }
        int[][] ret = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
