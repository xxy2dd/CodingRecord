package com.company.leetcode;

/**
 * @author xxy
 * @date 2019/7/6
 * @description ����һ��������?L��L0��L1������Ln-1��Ln �������������к��Ϊ�� L0��Ln��L1��Ln-1��L2��Ln-2����
 * �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
 * ʾ��?1:
 * �������� 1->2->3->4, ��������Ϊ 1->4->2->3.
 * ʾ�� 2:
 * �������� 1->2->3->4->5, ��������Ϊ 1->5->2->4->3.
 */
public class reorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // ����һ����ָ��һ����ָ���ҵ��м�Ľڵ�
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // ǰ�벿�ֵıȺ�벿�ֵ�Ҫ��һλ
        fast = slow.next;
        slow.next = null;
        // ��ת��벿������
        if (fast != null && fast.next != null) {
            fast = reverse(fast);
        }
        // �ϲ���������
        slow = head;
        while (fast != null) {
            // ��¼��ָ�����һλ
            ListNode tmpS = slow.next;
            // ��¼��ָ�����һλ
            ListNode tmpF = fast.next;
            // �ı�ָ��ָ��
            slow.next = fast;
            fast.next = tmpS;
            // ����ָ��ֱ����
            slow = tmpS;
            fast = tmpF;
        }
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // ��ת����  �ɲο���ָOffer �е�ReverseList
        // ������õ���ͷ�巨
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
