package com.learning4algorithm.basic;

/**
 * 前缀树
 */
public class TrieTreeTree {

    static class TrieNode {
        public int pass;
        public int end;
        public TrieNode[] nexts;
        // 也可用HashMap<Character, TrieNode>

        public TrieNode() {
            pass = 0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }

    static class TrieTree {

        private TrieNode root;

        public TrieTree() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            node.pass++;
            for (char c : chars) {
                int index = c - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        /**
         * 字符加入过几次
         */
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            for (char c : chars) {
                int index = c - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        /**
         * 以word前缀的数量
         */
        public int prefix(String word) {
            if (word == null) {
                return 0;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            for (char c : chars) {
                int index = c - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }

        /**
         * 删除时，注意p为0的情况,连同节点删除
         *
         * @param word
         */
        public void delete(String word) {
            if (word == null) {
                return;
            }
            // 确保存在
            int count = search(word);
            if (count == 0) {
                return;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            node.pass--;
            for (char c : chars) {
                int index = c - 'a';
                if (--node.nexts[index].pass == 0) {
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
        }
    }
}
