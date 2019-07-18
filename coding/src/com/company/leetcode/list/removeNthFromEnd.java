package com.company.leetcode.list;

import com.company.leetcode.list.ListNode;

/**
 * @author xxy
 * @date 2019/7/8
 * @description
 */
public class removeNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0;i<n;i++){
            fast = fast.next;
        }
        // 删除头结点
        if (fast == null) {
            return head.next;
        }

        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;

        slow.next = slow.next.next;
        temp.next = null;
        return head;
    }
    // 由于头节点没有前一个节点了，如何删除头节点？
    // 在头节点前面加入临时头节点，这样原头节点就和普通节点一致
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        // 为了方便操作建立临时头节点
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode first = tempHead;
        ListNode second = tempHead;
        // 让first先走n+1步
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // 两个指针一起走，当first走到链尾，second就走到倒数第n+1个节点
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        // 删除下一个节点即删除倒数第n个节点
        second.next = second.next.next;
        return tempHead.next;
    }
}
