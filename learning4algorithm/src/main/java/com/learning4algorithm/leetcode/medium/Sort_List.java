package com.learning4algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort_List {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        Collections.sort(list);
        ListNode p2 = new ListNode(list.get(0));
        ListNode ret = p2;
        for (int i = 1; i < list.size(); i++) {
            p2.next = new ListNode(list.get(i));
            p2 = p2.next;
        }
        return ret;
    }

    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode l1 = sortList2(head);
        ListNode l2 = sortList2(slow);
        return merge(l1, l2);
    }


    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return head.next;
    }
}
