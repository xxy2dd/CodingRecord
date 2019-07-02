package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(k<1||head==null){
            return null;
        }
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        for(int i = 0;i<k-1;i++){
            if(pointer1.next!=null){
                pointer1 = pointer1.next;
            }else{
                return null;
            }

        }
        while(pointer1.next!=null){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer2;

    }

}
