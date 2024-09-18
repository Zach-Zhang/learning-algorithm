package com.zach.geekbang.datastructure.skiplist;

import java.util.Random;

/**
 * 跳表实现
 */
public class SkipListV2 {

    private static final float P = 0.5f;
    private static final int MAX_LEVEL = 16;
    private SkipListNode head;
    private int level;
    private final Random random;

    public SkipListV2(){
        this.level = 0;
        this.head = new SkipListNode(0,MAX_LEVEL);
        this.random = new Random();
    }

    //随机生成节点的层数
    private int randomLevel(){
        int levelCount = 1;
        while (random.nextFloat()<P && levelCount<MAX_LEVEL){
            levelCount++;
        }
        return levelCount;
    }

    /**
     * 插入节点
     * @param value
     */
    public void inert(int value){
        int levelCount = randomLevel();
        SkipListNode newNode = new SkipListNode(value,levelCount);
        SkipListNode current = head;
        SkipListNode[] update = new SkipListNode[MAX_LEVEL+1];
        for (int i = level; i >=0; i--) {
            while (current.forward[i]!=null && current.forward[i].value<value){
                current = current.forward[i];
            }
            update[i] = current;
        }
        for (int i = 0; i < levelCount; i++) {
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }
        if(levelCount>level){
            level = levelCount;
        }
    }
    // 查找节点
    public boolean search(int value) {
        SkipListNode current = head;
        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value < value) {
                current = current.forward[i];
            }
        }
        current = current.forward[0];
        return current != null && current.value == value;
    }

    // 删除节点
    public void delete(int value) {
        SkipListNode[] update = new SkipListNode[MAX_LEVEL + 1];
        SkipListNode current = head;
        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value < value) {
                current = current.forward[i];
            }
            update[i] = current;
        }

        current = current.forward[0];
        if (current!=null&&current.value == value) {
            for (int i = 0; i <= level; i++) {
                if (update[i].forward[i] != current) {
                    break;
                }
                update[i].forward[i] = current.forward[i];
            }
            while (level > 0 && head.forward[level] == null) {
                level--;
            }
        }
    }

    // 打印跳表的内容
    public void display() {
        System.out.println("SkipList: ");
        for (int i = 0; i <= level; i++) {
            SkipListNode node = head.forward[i];
            System.out.print("Level " + i + ": ");
            while (node != null) {
                System.out.print(node.value + " ");
                node = node.forward[i];
            }
            System.out.println();
        }
    }
    public class SkipListNode{
        private int value;
        /**
         *  指向不同层级的指针数组
         */
        private SkipListNode[] forward;

        public SkipListNode(int value,int level){
            this.value = value;
            this.forward = new SkipListNode[level + 1];
        }
    }

}
