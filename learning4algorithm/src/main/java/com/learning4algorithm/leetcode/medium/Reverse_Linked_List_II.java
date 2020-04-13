package com.learning4algorithm.leetcode.medium;

public class Reverse_Linked_List_II {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode prev = null;
        int diff = n - m;
        while (--m > 0) {
            prev = p;
            p = p.next;
        }
        ListNode start = p;
        while (diff-- > 0) {
            p = p.next;
        }
        ListNode suffix = p.next;

        // start <->end
        ListNode iter = start;
        ListNode preNode = new ListNode(0);
        while (iter != suffix) {
            ListNode temp = iter.next;
            iter.next = preNode.next;
            preNode.next = iter;
            iter = temp;
        }
        if (prev != null) {
            prev.next = preNode.next;
        }
        if (suffix != null) {
            start.next = suffix;
        }
        return prev == null ? preNode.next : head;
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->NULL
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
       /* ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);*/
        node1.next = node2;
       /* node2.next = node3;
        node3.next = node4;
        node4.next = node5;*/
        reverseBetween(node1, 1, 2);
    }
}
