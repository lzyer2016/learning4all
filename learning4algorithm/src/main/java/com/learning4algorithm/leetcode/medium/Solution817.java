package com.learning4algorithm.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 817. Linked List Components
 */
public class Solution817 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int item : G) {
            set.add(item);
        }
        ListNode p = head;
        int count = 0;
        while (p != null) {
            if (set.contains(p.val)) {
                count++;
                while (p.next != null && set.contains(p.next.val)) {
                    p = p.next;
                }
            }
            p = p.next;
        }
        return count;
    }
}
