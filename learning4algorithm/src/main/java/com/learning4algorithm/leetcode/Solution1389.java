package com.learning4algorithm.leetcode;

/**
 * 1389. Create Target Array in the Given Order
 */
public class Solution1389 {
    
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] ret = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ret[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (ret[index[i]] == -1) {
                ret[index[i]] = nums[i];
            } else {
                // move
                move(ret, index[i], nums[i]);
            }
        }
        return ret;
    }

    public void move(int[] ret, int index, int num) {
        int position = -1;
        for (int i = index; i < ret.length && ret[i] != -1; i++) {
            position = i;
        }
        for (int i = position; i >= index; i--) {
            ret[i + 1] = ret[i];
        }
        ret[index] = num;
    }
}
