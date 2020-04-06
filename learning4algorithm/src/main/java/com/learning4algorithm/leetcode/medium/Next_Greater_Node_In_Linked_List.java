package com.learning4algorithm.leetcode.medium;

public class Next_Greater_Node_In_Linked_List {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] nextLargerNodes(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        int[] ret = new int[len];
        int index = 0;
        p = head;
        while (p != null) {
            if (p.next != null) {
                ListNode iterator = p.next;
                while (iterator != null && iterator.val <= p.val) {
                    iterator = iterator.next;
                }
                if (iterator != null) {
                    ret[index++] = iterator.val;
                } else {
                    ret[index++] = 0;
                }
            } else {
                ret[index++] = 0;
            }
            p = p.next;
        }
        return ret;
    }
}
