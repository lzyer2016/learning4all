package com.learning4algorithm.leetcode.medium;

import java.util.*;

public class LeetCode_863 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<TreeNode, TreeNode> parent;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parent = new HashMap<>();
        dfs(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        queue.add(target);
        int distance = 0;
        List<Integer> ret = new ArrayList<>();
        Set<TreeNode> seen = new HashSet<>();
        seen.add(null);
        seen.add(target);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (distance == K) {
                    for (TreeNode treeNode : queue) {
                        ret.add(treeNode.val);
                    }
                    return ret;
                }
                queue.add(null);
                distance++;
            } else {
                if (!seen.contains(node.left)) {
                    seen.add(node.left);
                    queue.add(node.left);
                }
                if (!seen.contains(node.right)) {
                    seen.add(node.right);
                    queue.add(node.right);
                }
                TreeNode par = parent.get(node);
                if (!seen.contains(par)) {
                    seen.add(par);
                    queue.add(par);
                }
            }
        }
        return ret;
    }

    public void dfs(TreeNode root, TreeNode par) {
        if (root != null) {
            parent.put(root, par);
            dfs(root.left, root);
            dfs(root.right, root);
        }
    }
}
