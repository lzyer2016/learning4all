package com.learning4algorithm.basic;

/**
 * **叶子节点**的最小距离
 */
public class MinimumDepthOfBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int run(TreeNode root) {
        return process(root);
    }

    public int process(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = process(node.left);
        int rightHeight = process(node.right);
        if (leftHeight == 0 || rightHeight == 0) {
            return leftHeight + rightHeight + 1;
        }
        return Math.min(leftHeight, rightHeight) + 1;
    }
}
