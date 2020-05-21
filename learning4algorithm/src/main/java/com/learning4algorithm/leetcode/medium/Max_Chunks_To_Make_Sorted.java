package com.learning4algorithm.leetcode.medium;

public class Max_Chunks_To_Make_Sorted {

    public int maxChunksToSorted(int[] arr) {
        int res = -1;
        int maxCur = 0;
        for (int i = 0; i < arr.length; i++) {
            maxCur = Math.max(maxCur, arr[i]);
            res += (maxCur == i ? 1 : 0);
        }
        return res;
    }
}
