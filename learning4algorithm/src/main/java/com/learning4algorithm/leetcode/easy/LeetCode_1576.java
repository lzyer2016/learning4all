package com.learning4algorithm.leetcode.easy;

public class LeetCode_1576 {

    public String modifyString(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '?') {
                arr[i] = 'a';
                if (i == 0 && arr.length > 1) {
                    if (arr[i] == arr[i + 1]) {
                        arr[i] = (char) (arr[i] + 1);
                    }
                }
                if (i == arr.length - 1 && arr.length > 1) {
                    if (arr[i] == arr[i - 1]) {
                        arr[i] = (char) (arr[i] + 1);
                    }
                }
                if (i > 0 && i < arr.length - 1) {
                    while (arr[i - 1] == arr[i] || arr[i + 1] == arr[i]) {
                        arr[i] = (char) (arr[i] + 1);
                    }
                }
            }
        }
        return new String(arr);
    }
}
