package com.zach.frequency;

/**
 * Created by Zach
 * Date :2020/9/24 8:22
 * Description :在 O(1) 时间内删除单向链表节点,
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * Version :1.0
 */
public class DeleteSingleNode {
    public static void main(String[] args) {

    }

    public static ListNode deleteNode(ListNode head, ListNode deleteNode) {
        if (head == null || deleteNode == null) {
            return null;
        }
        //要删除的节点不是尾结点
        if (deleteNode.next != null) {
            //将deleteNode的值替换成下一个节点的值,相当于deleteNode的前一个节点直接指向了deleteNode的下一个节点
            ListNode next = deleteNode.next;
            deleteNode.data = next.data;
            //将deleteNode.next指向next的下一个节点
            deleteNode.next = next.next;
        } else {
            //只有一个节点
            if (head == deleteNode) {
                head = null;
            } else {
                ListNode cur = head;
                while (cur.next != deleteNode) {
                    cur = cur.next;
                }
                cur.next = null;
            }
        }
        return head;
    }

    /**
     * @return void
     * @Author Zach
     * @Description 方法二利用哨兵模式, 先构建一个虚拟节点, 永远指向头结点
     * @Date 23:38 2020/9/28
     * @Param [head, val]
     **/
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        //构建哨兵节点
        ListNode preHead = new ListNode(-1, head);
        //preNode指向要删除的节点的前驱节点
        ListNode preNode = preHead;
        //指向要删除的节点
        ListNode deleteNode = preHead.next;
        boolean flag = false;
        while (deleteNode != null) {
            if (deleteNode.data == val) {
                flag = true;
                break;
            }
            preNode = preNode.next;
            deleteNode = deleteNode.next;
        }
        //没有找到,直接返回
        if (!flag) {
            return head;
        }
        //找到了,则改变前驱指向
        preNode.next = deleteNode.next;
        //返回删除目标节点后的链表头结点
        return preHead.next;


    }

    public static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

}
