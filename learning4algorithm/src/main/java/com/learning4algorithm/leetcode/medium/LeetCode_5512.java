package com.learning4algorithm.leetcode.medium;

public class LeetCode_5512 {

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = i;
            int y = -1;
            for (int j = 0; j < pairs.length; j++) {
                if (pairs[j][0] == i) {
                    y = pairs[j][1];
                    break;
                }
                if (pairs[j][1] == i) {
                    y = pairs[j][0];
                    break;
                }
            }
            int[] f1 = preferences[x];
            boolean first = false;
            boolean second = false;
            int yIndex = -1;
            for (int p = 0; p < f1.length; p++) {
                if (f1[p] == y) {
                    yIndex = p;
                    break;
                }
            }
            for (int p = 0; p < f1.length; p++) {
                if (p < yIndex) {
                    first = true;
                    break;
                }
            }
            for (int k = 0; k < f1.length; k++) {
                int index = f1[k];
                if (index != y) {
                    int position = -1;
                    for (int p = 0; p < preferences[index].length; p++) {
                        if (x == preferences[index][p]) {
                            position = p;
                            break;
                        }
                    }
                    for (int p = 0; p < preferences[index].length; p++) {
                        if (position < p && preferences[index][p] != y) {
                            second = true;
                            break;
                        }
                    }
                }
            }
            System.out.println(first + " : " + second);
            if (first && second) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 4
     * [[1,3,2],[2,3,0],[1,3,0],[0,2,1]]
     * [[1,3],[0,2]]
     * <p>
     * 4
     * [[1,3,2],[2,3,0],[1,0,3],[1,0,2]]
     * [[2,1],[3,0]]
     * <p>
     * <p>
     * 4
     * [[1,2,3],[3,2,0],[3,1,0],[1,2,0]]
     * [[0,1],[2,3]]
     * <p>
     * <p>
     * 6
     * [[1,4,3,2,5],[0,5,4,3,2],[3,0,1,5,4],[2,1,4,0,5],[2,1,0,3,5],[3,4,2,0,1]]
     * [[3,1],[2,0],[5,4]]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] preferences = {{1, 4, 3, 2, 5}, {0, 5, 4, 3, 2}, {3, 0, 1, 5, 4}, {2, 1, 4, 0, 5}, {2, 1, 0, 3, 5}, {3, 4, 2, 0, 1}};
        int[][] pairs = {{3, 1}, {2, 0}, {5, 4}};
        System.out.println(new LeetCode_5512().unhappyFriends(6, preferences, pairs));
    }

}
