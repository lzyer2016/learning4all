package com.learning4algorithm.leetcode.medium;

public class Letter_Tile_Possibilities {

    public int numTilePossibilities(String tiles) {
        int[] arr = new int[26];
        for (char c : tiles.toCharArray()) {
            arr[c - 'A']++;
        }
        return dfs(arr);
    }

    public int dfs(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                continue;
            sum++;
            arr[i]--;
            sum += dfs(arr);
            arr[i]++;
        }
        return sum;
    }
}
