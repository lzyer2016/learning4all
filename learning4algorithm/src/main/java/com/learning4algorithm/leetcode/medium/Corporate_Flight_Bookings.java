package com.learning4algorithm.leetcode.medium;

public class Corporate_Flight_Bookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] booking : bookings) {
            int start = booking[0];
            int end = booking[1];
            int count = booking[2];
            for (int i = start - 1; i < end; i++) {
                ans[i] += count;
            }
        }
        return ans;
    }
}
