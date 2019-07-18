package com.company.leetcode.list;

import com.company.leetcode.list.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xxy
 * @date 2019/7/6
 * @description
 * 合并?k?个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 示例:
 * 输入:
 * [ 1->4->5, 1->3->4, 2->6 ]
 * 输出: 1->1->2->3->4->4->5->6

 */
public class mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }
        // 利用最小堆
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        // 依次将每个链表的数加入堆中
        for(int i = 0;i<lists.length;i++){
            ListNode node =lists[i];
            while(node!=null){
                // 暂存节点信息
                ListNode temp=node;
                // 将节点的next置为null
                temp.next=null;
                // 加入堆
                queue.add(temp);
                // 节点后移一位
                node=node.next;
            }
        }
        ListNode res = new ListNode(-1);
        ListNode p =res;
        // 新建一个节点 依次取出堆中的节点放入链表
        while(!queue.isEmpty()){
            p.next = queue.poll();
            p = p.next;
        }
        return res.next;
    }
}
