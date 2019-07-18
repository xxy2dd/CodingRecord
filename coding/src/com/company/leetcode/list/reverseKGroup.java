package com.company.leetcode.list;

/**
 * @author xxy
 * @date 2019/7/6
 * @description
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 * k是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 示例 :
 * 给定这个链表：1->2->3->4->5
 * 当k= 2 时，应当返回: 2->1->4->3->5
 * 当k= 3 时，应当返回: 3->2->1->4->5
 * 说明 :
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 */
public class reverseKGroup {
    public static void main(String[] args) {
        reverseKGroup r = new reverseKGroup();
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 2; i < 6; i++) {
            head.next = new ListNode(i);
            head = head.next;
        }
        head = p;
        System.out.println("旋转前：");
        while(p!=null){
            System.out.println(p.val + " ");
            p = p.next;
        }
        ListNode res = r.reverseKGroup(head, 2);
        System.out.println("旋转后：");
        while(res!=null){
            System.out.println(res.val + " ");
            res = res.next;
        }

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) {
            //find the k+1 node
            curr = curr.next;
            count++;
        }

        if (count == k) {
            // 递归（巧妙） curr得到上一个k组旋转之后的头结点，或者不满k个节点的头结点
            curr = reverseKGroup(curr, k);
            // 翻转k个数
            while (count-- > 0) {
                ListNode next = head.next;
                head.next = curr;
                curr = head;
                head = next;
            }
            head = curr;
        }
        return head;
    }
}
