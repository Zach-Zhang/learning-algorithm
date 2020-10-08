package com.zach.frequency;

/**
 * Created by Zach
 * Date :2020/10/8 17:46
 * Description : 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。例如：1->2->3->3->4->4->5处理后为1->2->5
 * Version :1.0
 */
public class DeleteMultipleNode {
    public static void main(String[] args) {

    }

    /**
     * @return com.zach.frequency.DeleteMultipleNode.ListNode
     * @Author Zach
     * @Description 方法一使用使用递归的方式处理
     * @Date 20:42 2020/10/8
     * @Param [head]
     **/
    public static ListNode deleteMultipleNode(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        //对重复节点的处理
        if (head.data == next.data) {
            //遍历到没有重复节点的位置
            while (next != null && head.data == next.data) {
                next = next.next;
            }
            return deleteMultipleNode(next);
        } else {
            //没有重复节点
            head.next = deleteMultipleNode(head.next);
            return head;
        }
    }

    /**
     * @return com.zach.frequency.DeleteMultipleNode.ListNode
     * @Author Zach
     * @Description 方法二, 使用非递归的方式处理
     * @Date 20:42 2020/10/8
     * @Param [pHead]
     **/
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        //初始化哨兵节点,永远指向头结点
        ListNode head = new ListNode(-1, pHead);
        //preNode指向确定不重复的节点
        ListNode preNode = head;
        ListNode lastNode = head.next;
        while (lastNode != null) {
            //找到重复的节点
            if (lastNode.next != null && lastNode.data == lastNode.next.data) {
                //找到last往后不重复的节点位置
                while (lastNode.next != null && lastNode.data == lastNode.next.data) {
                    lastNode = lastNode.next;
                }
                //删除重复节点
                preNode.next = lastNode.next;
                lastNode = lastNode.next;
            } else {
                //如果不重复,则preNode和LastNode分别往后移动
                preNode = preNode.next;
                lastNode = lastNode.next;
            }
        }
        return head.next;
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
