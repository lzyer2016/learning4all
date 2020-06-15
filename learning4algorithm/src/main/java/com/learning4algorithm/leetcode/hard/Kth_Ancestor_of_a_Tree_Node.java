package com.learning4algorithm.leetcode.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Kth_Ancestor_of_a_Tree_Node {

    private Map<Integer, Integer> nodeMap;

    public Kth_Ancestor_of_a_Tree_Node(int n, int[] parent) {
        nodeMap = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            nodeMap.put(i, parent[i]);
        }
    }

    public int getKthAncestor(int index, int k) {
        if (((int) (Math.log(index) / Math.log(2)) + 1) < k) {
            return -1;
        }
        Integer pos = index;
        while (k > 0) {
            pos = nodeMap.get(pos);
            if (Objects.isNull(pos)) {
                return -1;
            }
            k--;
        }
        return pos;
    }

    /**
     * ["TreeAncestor","getKthAncestor","getKthAncestor","getKthAncestor","getKthAncestor","getKthAncestor","getKthAncestor","getKthAncestor","getKthAncestor","getKthAncestor","getKthAncestor"]
     * [[10,[-1,0,0,1,2,0,1,3,6,1]],[8,6],[9,7],[1,1],[2,5],[4,2],[7,3],[3,7],[9,6],[3,5],[8,8]]
     *
     * @param args [null,-1,-1,-1,-1,0,-1,-1,-1,-1,-1]
     *             [null,-1,-1,0,-1,0,0,-1,-1,-1,-1]
     */
    public static void main(String[] args) {
        int n = 10;
        int[] arr = {-1, 0, 0, 1, 2, 0, 1, 3, 6, 1};
        Kth_Ancestor_of_a_Tree_Node test = new Kth_Ancestor_of_a_Tree_Node(n, arr);
        System.out.println(test.getKthAncestor(1, 1));
        System.out.println(test.getKthAncestor(7, 3));


       // System.out.println((int) (Math.log(1) / Math.log(2)));
    }
}
