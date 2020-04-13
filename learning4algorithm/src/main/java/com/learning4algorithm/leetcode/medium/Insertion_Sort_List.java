package com.learning4algorithm.leetcode.medium;

public class Insertion_Sort_List {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode next = head.next;
        p.next = null;
        while (next != null) {
            ListNode iter = p;
            ListNode prev = null;
            while (iter != null && next.val > iter.val) {
                prev = iter;
                iter = iter.next;
            }
            if (prev == null) {
                ListNode temp = next.next;
                next.next = iter;
                p = next;
                next = temp;
            } else {
                ListNode temp = next.next;
                next.next = prev.next;
                prev.next = next;
                next = temp;
            }
        }
        return p;
    }
}
