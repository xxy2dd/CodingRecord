package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * ��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣
 * ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
 * ˼·��
 * �ݹ�
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null||pHead.next==null){
            return pHead;
        }
        ListNode pNext = pHead.next;
        // �жϵ�һ���ڵ�͵ڶ����ڵ��Ƿ���ͬ
        if(pHead.val==pNext.val){
            // ��ȼ����жϺ����Ƿ�����ȵ�
            while(pNext!=null&&pHead.val==pNext.val){
                pNext = pNext.next;
            }
            // �Ե�ǰ�ڵ��ظ���һ����
            return deleteDuplication(pNext);
        }else{
            pHead.next =  deleteDuplication(pHead.next);
            return pHead;
        }
    }
}
