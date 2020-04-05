package com.learning4algorithm.leetcode.easy;

/**
 * 1290. Convert Binary Number in a Linked List to Integer
 */
public class Solution1290 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int getDecimalValue(ListNode head) {
        int sum = 0;
        ListNode p = head;
        while (p != null) {
            sum = sum * 2 + p.val;
            p = p.next;
        }
        return sum;
    }
}
