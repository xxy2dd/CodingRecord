package com.company.leetcode.list;

/**
 * @author xxy
 * @date 2019/7/18
 * @description
 * ��O(nlogn) ʱ�临�ӶȺͳ������ռ临�Ӷ��£��������������
 * ʾ�� 1:
 * ����: 4->2->1->3
 * ���: 1->2->3->4
 * ʾ�� 2:
 * ����: -1->5->3->4->0
 * ���: -1->0->3->4->5
 *
 * ע��ʱ��Ϳռ临�Ӷȵ�Ҫ�����Բ����˹鲢�����ȶ���
 */
public class sortList {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);

    }
    public ListNode mergeSort(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        // ���ÿ���ָ���ҵ�������м�ڵ�
        ListNode fast = head,slow = head;
        // ע��while������
        while(fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // �Ͽ�����
        fast = slow.next;
        slow.next = null;
        slow = head;
        // �ݹ� ����
        ListNode head1 = sortList(slow);
        ListNode head2 = sortList(fast);
        // �ϲ�
        return merge(head1,head2);
    }
    public ListNode merge(ListNode head1,ListNode head2){
        // �½�ͷ���
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while(head1!=null&&head2!=null){
            if(head1.val<=head2.val){
                p.next = head1;
                head1 = head1.next;
            }else{
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        // ����δ�������
        if(head1!=null){
            p.next = head1;
        }
        if(head2!=null){
            p.next = head2;
        }
        
        return head.next;
    }
}
