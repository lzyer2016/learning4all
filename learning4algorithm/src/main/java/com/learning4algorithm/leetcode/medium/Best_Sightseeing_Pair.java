package com.learning4algorithm.leetcode.medium;

public class Best_Sightseeing_Pair {

    public int maxScoreSightseeingPair(int[] A) {
        int ans = A[0];
        int preIndex = 0;
        for (int j = 1; j < A.length; j++) {
            ans = Math.max(ans, A[preIndex] + preIndex + A[j] - j);
            if (A[preIndex] + preIndex < A[j] + j) {
                preIndex = j;
            }
        }
        return ans;
    }

}
