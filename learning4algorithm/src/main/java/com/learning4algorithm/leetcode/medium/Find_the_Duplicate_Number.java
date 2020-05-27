package com.learning4algorithm.leetcode.medium;

public class Find_the_Duplicate_Number {

    public int findDuplicate(int[] nums) {
        int high = nums.length - 1;
        int low = 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            int count = 0;
            for (int a : nums) {
                if (a <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
