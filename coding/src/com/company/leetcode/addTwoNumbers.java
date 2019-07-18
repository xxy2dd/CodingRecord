package com.company.leetcode;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class    addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 新建头结点
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        // 记录进位
        int carry = 0;
        while (p != null || q != null) {
            // 注意判空
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            // 是否比10大，取商
            carry = sum / 10;
            // 结果取余
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            // 链表后移 注意判空
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;

    }
}
