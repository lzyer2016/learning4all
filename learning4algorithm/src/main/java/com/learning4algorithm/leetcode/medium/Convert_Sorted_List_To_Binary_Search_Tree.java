package com.learning4algorithm.leetcode.medium;

public class Convert_Sorted_List_To_Binary_Search_Tree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return partition(head, null);
    }

    public TreeNode partition(ListNode left, ListNode right) {
        ListNode slow = left;
        ListNode fast = left;
        if(left == right){
            return null;
        }
        while (fast != right && fast.next != right) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        TreeNode leftNode = partition(left, slow);
        TreeNode rightNode = partition(slow.next, right);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
