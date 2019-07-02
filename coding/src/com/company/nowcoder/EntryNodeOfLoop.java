package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead==null||pHead.next==null){
            return null;
        }
        ListNode slow = pHead,fast=pHead;
        do{
            slow = slow.next;
            fast = fast.next.next;
        }while(slow!=fast);
        fast=pHead;
        while(slow!=fast){
            slow=slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
