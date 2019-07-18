package com.company.leetcode.list;

/**
 * @author xxy
 * @date 2019/7/18
 * @description
 * 在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 示例 1:
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 注意时间和空间复杂度的要求，所以采用了归并排序（稳定）
 */
public class sortList {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);

    }
    public ListNode mergeSort(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        // 利用快慢指针找到链表的中间节点
        ListNode fast = head,slow = head;
        // 注意while的条件
        while(fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // 断开链表
        fast = slow.next;
        slow.next = null;
        slow = head;
        // 递归 分治
        ListNode head1 = sortList(slow);
        ListNode head2 = sortList(fast);
        // 合并
        return merge(head1,head2);
    }
    public ListNode merge(ListNode head1,ListNode head2){
        // 新建头结点
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
        // 考虑未放完情况
        if(head1!=null){
            p.next = head1;
        }
        if(head2!=null){
            p.next = head2;
        }
        
        return head.next;
    }
}
