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
        // ɾ��ͷ���
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
    // ����ͷ�ڵ�û��ǰһ���ڵ��ˣ����ɾ��ͷ�ڵ㣿
    // ��ͷ�ڵ�ǰ�������ʱͷ�ڵ㣬����ԭͷ�ڵ�ͺ���ͨ�ڵ�һ��
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        // Ϊ�˷������������ʱͷ�ڵ�
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode first = tempHead;
        ListNode second = tempHead;
        // ��first����n+1��
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // ����ָ��һ���ߣ���first�ߵ���β��second���ߵ�������n+1���ڵ�
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        // ɾ����һ���ڵ㼴ɾ��������n���ڵ�
        second.next = second.next.next;
        return tempHead.next;
    }
}
