package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * ˼·��
 * ��һ������ÿ���ڵ�ĺ�����븴�ƵĽڵ㡣
 * �ڶ������Ը��ƽڵ�� random ���ӽ��и�ֵ��
 * ����������֡�
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
                // clone ��randomҪָ�����Ǹ���֮��Ľڵ� ������cur.random.next
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
