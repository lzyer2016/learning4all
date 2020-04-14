package com.learning4algorithm.leetcode.medium;

public class Remove_Duplicates_from_Sorted_List_II {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode p = head;
        ListNode prev = preHead;
        while (p != null) {
            boolean flag = false;
            while (p.next != null && p.val == p.next.val) {
                flag = true;
                p = p.next;
            }
            if (flag) {
                prev.next = p.next;
            } else {
                prev.next = p;
                prev = p;
            }
            p = p.next;
        }
        return preHead.next;
    }
}
