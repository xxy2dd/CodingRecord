package com.company.leetcode;

/**
 * @author xxy
 * @date 2019/7/1
 * @description
 */
public class detectCycle {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        // ×¢ÒâÅÐ¿Õ
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast){
                fast = head;
                while(fast!=slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
