package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�
 * ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
 */
public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null)
            return pNode;
        if (pNode.right != null) { // �ڵ���������
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        } else if ( pNode.next != null && pNode.next.left == pNode) { // �ڵ����������Ҹýڵ�Ϊ���ڵ�����ӽڵ�
            return pNode.next;
        } else if (pNode.next != null && pNode.next .right == pNode) { // �ڵ����������Ҹýڵ�Ϊ���ڵ�����ӽڵ�
            while(pNode.next != null && pNode .next .left != pNode){
                pNode = pNode.next ;
            }
            return pNode.next ;
        }else{
            return pNode.next ;//�ڵ��޸��ڵ� �����ڵ�Ϊ���ڵ�
        }

    }
}
