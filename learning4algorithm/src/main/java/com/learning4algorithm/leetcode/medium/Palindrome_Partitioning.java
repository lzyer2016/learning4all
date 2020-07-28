package com.learning4algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        help(s, new ArrayList<>(), ret);
        return ret;
    }

    public void help(String str, List<String> step, List<List<String>> ret) {
        if (str == null || str.length() == 0) {
            ret.add(new ArrayList<>(step));
            return;
        }
        for (int i = 1; i <= str.length(); i++) {
            String temp = str.substring(0, i);
            if (!isPalindrome(temp)) {
                continue;
            }
            step.add(temp);
            help(str.substring(i), step, ret);
            step.remove(step.size() - 1);
        }
    }

    public boolean isPalindrome(String path) {
        int low = 0;
        int high = path.length() - 1;
        while (low < high) {
            if (path.charAt(low) != path.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
