package com.learning4algorithm.leetcode.medium;

public class Count_Number_of_Teams {

    public static int numTeams(int[] rating) {
        if (rating == null) {
            return 0;
        }
        int ret = 0;
        for (int i = 0; i < rating.length; i++) {
            for (int j = i + 1; j < rating.length; j++) {
                for (int k = j + 1; k < rating.length; k++) {
                    if ((rating[k] > rating[j] && rating[j] > rating[i]) || (rating[k] < rating[j] && rating[j] < rating[i])) {
                        ret++;
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 4, 1};
        System.out.println(numTeams(arr));
    }
}
