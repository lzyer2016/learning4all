package com.learning4algorithm.leetcode.easy;

public class LeetCode_5629 {

    public static String reformatNumber(String number) {
        number = number.replaceAll("-", "");
        number = number.replaceAll(" ", "");
        int len = number.length();
        StringBuilder str = new StringBuilder();
        if (len % 3 == 0) {
            int index = 1;
            for (int i = 0; i < len; i++) {
                str.append(number.charAt(i));
                if (index % 3 == 0 && i < len - 1) {
                    str.append("-");
                    index = 0;
                }
                index++;
            }
        }
        if (len % 3 == 1) {
            int n = (len / 3);
            int time = (n - 1) * 3;
            int index = 1;
            for (int i = 0; i < time; i++) {
                str.append(number.charAt(i));
                if (index % 3 == 0) {
                    str.append("-");
                    index = 0;
                }
                index++;
            }
            String substring = number.substring(time);
            str.append(substring.substring(0, 2));
            str.append("-");
            str.append(substring.substring(2));
        }
        if (len % 3 == 2) {
            int time = (len / 3) * 3;
            int index = 1;
            for (int i = 0; i < time; i++) {
                str.append(number.charAt(i));
                if (index % 3 == 0) {
                    str.append("-");
                    index = 0;
                }
                index++;
            }
            str.append(number.substring(time));
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(reformatNumber("1234561234434"));
    }
}
