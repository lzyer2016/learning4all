package com.learning4algorithm.leetcode.medium;

import java.util.Arrays;

public class Maximum_Area {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int hmax = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        for (int i = 0; i < horizontalCuts.length - 1; i++) {
            hmax = Math.max(hmax, horizontalCuts[i + 1] - horizontalCuts[i]);
        }

        int vmax = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        for (int i = 0; i < verticalCuts.length - 1; i++) {
            vmax = Math.max(vmax, verticalCuts[i + 1] - verticalCuts[i]);
        }
        return (int)((long)hmax*vmax % 1000000007);
    }
}
