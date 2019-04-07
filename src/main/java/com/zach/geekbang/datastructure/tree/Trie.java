package com.zach.geekbang.datastructure.tree;

/**
 * @Auther: Zach
 * @Date: 2019/4/6 21:13
 * @Description:
 */
public class Trie {

    private TrieNode root = new TrieNode('/');

    //往Trie树中插入一个字符串
    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    //在Trie树中查找一个字符串
    public boolean find(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                return false;
            }

            p = p.children[index];
        }

        if (p.isEndingChar == false)
            return false;
        else
            return true;
    }

    public class TrieNode {
        private char data;
        private TrieNode[] children = new TrieNode[26];
        private boolean isEndingChar = false;

        public boolean isEndingChar() {
            return isEndingChar;
        }

        public void setEndingChar(boolean endingChar) {
            isEndingChar = endingChar;
        }

        public char getData() {
            return data;
        }

        public void setData(char data) {
            this.data = data;
        }

        public TrieNode(char data) {
            this.data = data;
        }
    }
}
