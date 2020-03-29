package com.learning4algorithm.basic;

/**
 * 判断搜索二叉树
 */
public class BSTTest {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    static class Info {
        boolean isBST;
        int max;
        int min;

        Info(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

    public boolean isBST(Node head) {
        Info info = process(head);
        return info.isBST;
    }

    public Info process(Node x) {
        if (x == null) {
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int max = x.value;
        int min = x.value;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }
        boolean isBST = false;
        if ((leftInfo != null ? (leftInfo.isBST && leftInfo.max < x.value) : true) &&
                (rightInfo != null ? (rightInfo.isBST && rightInfo.min > x.value) : true)) {
            isBST = true;
        }
        return new Info(isBST, max, min);
    }

}
