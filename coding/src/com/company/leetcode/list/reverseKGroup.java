package com.company.leetcode.list;

/**
 * @author xxy
 * @date 2019/7/6
 * @description
 * ����һ������ÿk���ڵ�һ����з�ת�����㷵�ط�ת�������
 * k��һ��������������ֵС�ڻ��������ĳ��ȡ�
 * ����ڵ���������k������������ô�뽫���ʣ��Ľڵ㱣��ԭ��˳��
 * ʾ�� :
 * �����������1->2->3->4->5
 * ��k= 2 ʱ��Ӧ������: 2->1->4->3->5
 * ��k= 3 ʱ��Ӧ������: 3->2->1->4->5
 * ˵�� :
 * ����㷨ֻ��ʹ�ó����Ķ���ռ䡣
 * �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����

 */
public class reverseKGroup {
    public static void main(String[] args) {
        reverseKGroup r = new reverseKGroup();
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 2; i < 6; i++) {
            head.next = new ListNode(i);
            head = head.next;
        }
        head = p;
        System.out.println("��תǰ��");
        while(p!=null){
            System.out.println(p.val + " ");
            p = p.next;
        }
        ListNode res = r.reverseKGroup(head, 2);
        System.out.println("��ת��");
        while(res!=null){
            System.out.println(res.val + " ");
            res = res.next;
        }

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) {
            //find the k+1 node
            curr = curr.next;
            count++;
        }

        if (count == k) {
            // �ݹ飨��� curr�õ���һ��k����ת֮���ͷ��㣬���߲���k���ڵ��ͷ���
            curr = reverseKGroup(curr, k);
            // ��תk����
            while (count-- > 0) {
                ListNode next = head.next;
                head.next = curr;
                curr = head;
                head = next;
            }
            head = curr;
        }
        return head;
    }
}
