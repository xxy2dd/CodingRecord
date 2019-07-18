package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * 思路：
 * 第一步，在每个节点的后面插入复制的节点。
 * 第二步，对复制节点的 random 链接进行赋值。
 * 第三步，拆分。
 */
public class CloneLinkedList {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null){
            return null;
        }
        RandomListNode cur = pHead;
        while(cur!=null){
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        cur = pHead;
        while(cur!=null){
            RandomListNode clone = cur.next;
            if(cur.random!=null){
                // clone 的random要指向我们复制之后的节点 所以是cur.random.next
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(cur.next!=null){
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return pCloneHead;
    }
}
