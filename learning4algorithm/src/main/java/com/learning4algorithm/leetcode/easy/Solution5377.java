package com.learning4algorithm.leetcode.easy;

/**
 * Number of Steps to Reduce a Number in Binary Representation to One
 */
public class Solution5377 {

    public static int numSteps(String s) {
        if (s.length() == 1 && s.charAt(0) == '1') {
            return 0;
        }
        int step = 0;
        while (!(s.length() == 1 && s.charAt(0) == '1')) {
            if (s.charAt(s.length() - 1) == '1') {
                char[] chars = s.toCharArray();
                int index = s.length() - 1;
                while (index >= 0) {
                    if (chars[index] == '0') {
                        chars[index] = '1';
                        break;
                    } else {
                        chars[index] = '0';
                    }
                    index--;
                }
                // exist plus 1
                if (index < 0 && chars[0] == '0') {
                    char[] temp = new char[chars.length + 1];
                    temp[0] = '1';
                    System.arraycopy(chars, 0, temp, 1, chars.length);
                    s = new String(temp);
                } else {
                    s = new String(chars);
                }
            } else {
                s = s.substring(0, s.length() - 1);
            }
            step++;
        }
        return step;
    }
}
