package com.learning4algorithm.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class Rearrange_Words_in_a_Sentence {

    public String arrangeWords(String text) {
        String[] arr = text.split(" ");
        arr[0] = arr[0].toLowerCase();
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        arr[0] = arr[0].substring(0, 1).toUpperCase() + arr[0].substring(1);
        return String.join(" ", arr);
    }
}
