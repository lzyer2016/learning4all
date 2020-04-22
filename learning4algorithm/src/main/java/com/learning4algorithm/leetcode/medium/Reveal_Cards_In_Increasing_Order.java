package com.learning4algorithm.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Reveal_Cards_In_Increasing_Order {

    public int[] deckRevealedIncreasing(int[] deck) {
        if (deck == null) {
            return null;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = deck.length - 1; i >= 0; i--) {
            if (queue.size() > 0) queue.add(queue.poll());
            queue.add(deck[i]);
        }
        int[] res = new int[deck.length];
        for (int i = deck.length - 1; i >= 0; i--) {
            res[i] = queue.poll();
        }
        return res;
    }
}
