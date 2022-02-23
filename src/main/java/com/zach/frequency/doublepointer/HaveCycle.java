package com.zach.frequency.doublepointer;

import com.zach.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Zach
 * @Date 2022/2/23 11:50
 * Version :1.0
 */
public class HaveCycle {
    public static void main(String[] args) {

    }

    /**
     * 哈希表，遍历所有的节点，如果存在之前访问过的节点，则有环
     * 但是空间复杂度O(N)不符合要求
     *
     * @param head
     * @return
     */
    public static boolean haveCycle1(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (!nodeSet.add(head)) {
                return true;
            }
            head = head.getNext();
        }
        return false;
    }

    /**
     * 快慢双指针，定义两个指针，一个指针从head开始移动，每次移动一个节点
     * 另一个指针从head.next开始，每次移动两个节点，如果链表存在环，则两个指针一定会在环内相遇，否则快指针会先到达链表尾部
     * 为什么快慢指针的出发点不一样，
     * 因为while循环，判断条件先执行，如果都在同一个位置，就无法进入循环体了，如果要在同一个节点，可以用do---while循环
     *
     * @param head
     * @return
     */
    public static boolean haveCycle2(ListNode head) {
        ListNode fast = head.getNext();
        ListNode slow = head;
        while (fast != slow) {
            //快指针到达尾部,说明不存在环
            if (fast == null || fast.getNext() == null) {
                return false;
            }
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return true;
    }
}
