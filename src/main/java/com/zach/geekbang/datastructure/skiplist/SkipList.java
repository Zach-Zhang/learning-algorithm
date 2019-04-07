package com.zach.geekbang.datastructure.skiplist;

import java.util.Random;

/***
 * 跳表的一种实现方法
 * 跳表中存储的正整数,并且存储的是不重复的
 *
 * 实现思路的一种理解
 * 1.每次插入数据的时候随机产生的level:决定了新节点的层数；
 * 2.数组update的作用：用以存储新节点所有层数上，各自的前一个节点的信息；
 * 3.节点内的forwards数组：用以存储该节点所有层的下一个节点的信息；
 * 4.当所有节点的最大层级变量maxlevel=1的时候，跳表退化成一个普通链表
 */
public class SkipList {

    private static int MAX_LEVEL = 16;

    private int levelCount = 1;

    private Node head = new Node(); //带头链表

    private Random r = new Random();

    public Node find(int value) {
        Node p = head;
        for(int i = levelCount-1;i>=0;--i) {
            while (p.forwards[i] !=null && p.forwards[i].data <value) {
                p = p.forwards[i];
            }
        }

        if(p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        }else {
            return null;
        }
    }

    public void insert(int value) {
        int level = randomLevel();
        Node newNode = new Node();
        newNode.maxLevel = level;
        Node update[] = new Node[level];
        for (int i=0;i<level;++i) {
            update[i] = head;
        }

        //record every level largest value which smaller insert value in update[]
        Node p = head;
        for (int i = level-1;i>=0;--i) {
            while (p.forwards[i] != null && p.forwards[i].data<value) {
                p = p.forwards[i];
            }

            update[i] = p; //use update save node in search path
        }

        //in search path node next node become new node forward(next)
        for (int i =0;i<level;++i) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }

        //update node hight
        if(levelCount <level)
            levelCount = level;
    }

    public void delete(int value) {
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount-1;i>=0;--i) {
            while (p.forwards[i] != null && p.forwards[i].data <value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        if(p.forwards[0] != null && p.forwards[0].data == value) {
            for (int i= levelCount-1;i>=0;--i) {
                if(update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }
    }

    //随机level次,如果是奇数层数+1,防止伪随机
    private int randomLevel() {
        int level = 1;
        for(int i = 1; i<MAX_LEVEL;++i) {
            if(r.nextInt() % 2 == 1) {
                level ++;
            }
        }
        return level;
    }

    public void printAll() {
        Node p = head;
        while (p.forwards[0] != null) {
            System.out.println(p.forwards[0] + " ");
            p = p.forwards[0];
        }
        System.out.println();
    }

    private class Node {
        private int data = -1;
        private Node forwards[] = new Node[MAX_LEVEL];
        private int maxLevel = 0;

        @Override
        public String toString(){
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
        }
    }
}
