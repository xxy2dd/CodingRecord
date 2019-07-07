package com.company.leetcode;

/**
 * @author xxy
 * @date 2019/7/6
 * @description 给定一个单链表?L：L0→L1→…→Ln-1→Ln ，将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例?1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class reorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // 先用一个快指针一个慢指针找到中间的节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 前半部分的比后半部分的要多一位
        fast = slow.next;
        slow.next = null;
        // 反转后半部分链表
        if (fast != null && fast.next != null) {
            fast = reverse(fast);
        }
        // 合并两个链表
        slow = head;
        while (fast != null) {
            // 记录慢指针的下一位
            ListNode tmpS = slow.next;
            // 记录快指针的下一位
            ListNode tmpF = fast.next;
            // 改变指针指向
            slow.next = fast;
            fast.next = tmpS;
            // 快慢指针分别后移
            slow = tmpS;
            fast = tmpF;
        }
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 反转链表  可参考剑指Offer 中的ReverseList
        // 这里采用的是头插法
        ListNode p = head.next;
        ListNode q = null;
        while (p.next != null) {
            q = p.next;
            p.next = q.next;
            q.next = head.next;
            head.next = q;
        }
        ListNode pHead = head.next;
        p.next = head;
        head.next=null;
        return pHead;
    }

    public ListNode reverse2(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode p = new ListNode(-1);
        ListNode pHead = p;
        p.next = head;
        while(head.next!=null){
            ListNode temp = p.next;
            p.next = head.next;
            head.next = head.next.next;
            p.next.next = temp;
        }
        return p.next;
    }
}
