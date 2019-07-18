package com.company.leetcode.list;

import com.company.leetcode.list.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xxy
 * @date 2019/7/6
 * @description
 * �ϲ�?k?�������������غϲ������������������������㷨�ĸ��Ӷȡ�
 * ʾ��:
 * ����:
 * [ 1->4->5, 1->3->4, 2->6 ]
 * ���: 1->1->2->3->4->4->5->6

 */
public class mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }
        // ������С��
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        // ���ν�ÿ����������������
        for(int i = 0;i<lists.length;i++){
            ListNode node =lists[i];
            while(node!=null){
                // �ݴ�ڵ���Ϣ
                ListNode temp=node;
                // ���ڵ��next��Ϊnull
                temp.next=null;
                // �����
                queue.add(temp);
                // �ڵ����һλ
                node=node.next;
            }
        }
        ListNode res = new ListNode(-1);
        ListNode p =res;
        // �½�һ���ڵ� ����ȡ�����еĽڵ��������
        while(!queue.isEmpty()){
            p.next = queue.poll();
            p = p.next;
        }
        return res.next;
    }
}
