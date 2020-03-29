package com.learning4algorithm.basic;

/**
 * 判断平衡二叉树
 */
public class BalancedTreeTest {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    static class Info {
        boolean isBalanced;
        int height;

        Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static Info process(Node x) {
        if (x == null) {
            return new Info(true, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalanced = false;
        if (leftInfo.isBalanced && rightInfo.isBalanced && Math.abs(leftInfo.height - rightInfo.height) <= 1) {
            isBalanced = true;
        }
        return new Info(isBalanced, height);
    }

    public static boolean isBalanced(Node head) {
        Info info = process(head);
        return info.isBalanced;
    }
}
