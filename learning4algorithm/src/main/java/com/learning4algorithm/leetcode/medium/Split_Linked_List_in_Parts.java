package com.learning4algorithm.leetcode.medium;

public class Split_Linked_List_in_Parts {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }

    public static ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        ListNode p = root;
        while (p != null) {
            len++;
            p = p.next;
        }
        int average = len / k;
        int more = len % k;
        if (len <= k) {
            ListNode[] ret = new ListNode[k];
            int index = 0;
            ListNode p2 = root;
            while (p2 != null) {
                ret[index] = p2;
                ret[index].next = null;
                p2 = p2.next;
                index++;
            }
            return ret;
        } else {
            ListNode[] ret = new ListNode[k];
            ListNode p3 = root;
            for (int i = 0; i < k; i++) {
                ListNode item = p3;
                int index = average;
                while (index-- > 1) {
                    item = item.next;
                }
                if (more > 0) {
                    item = item.next;
                    more--;
                }
                ListNode next = item.next;
                item.next = null;
                ret[i] = p3;
                p3 = next;
            }
            return ret;
        }
    }
}
