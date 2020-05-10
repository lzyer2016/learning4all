package com.learning4algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Build_an_Array_With_Stack_Operations {

    public static List<String> buildArray(int[] target, int n) {
        String push = "Push";
        String pop = "Pop";
        List<String> ret = new ArrayList<>();
        int index = 0;
        for (int i = 1; i <= n && index < target.length; i++) {
            if (i == target[index]) {
                ret.add(push);
                index++;
            } else {
                ret.add(push);
                ret.add(pop);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(1 ^ 1);
    }
}
