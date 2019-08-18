package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1,l2 = pHead2;
        while(l1!=l2){
            // 如果遍历到头 则指向另一条链表的头结点
            l1 = (l1==null)?pHead2:l1.next;
            l2 = (l2==null)?pHead1:l2.next;
        }
        return l1;

    }
}
