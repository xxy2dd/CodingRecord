package com.company.traverse;

/**
 * @author xxy
 * @date 2019/7/7
 * @description
 */
public class inOrderRecursion {
    public void inOrderRecursion(TreeNode node){
        //������Ϊ���򷵻�
        if(node==null) {
            return;
        }
        //��������
        inOrderRecursion(node.left);
        //���ʸ��ڵ�
        visit(node);
        //�����Һ���
        inOrderRecursion(node.right);
    }
    private void visit(TreeNode node){
        System.out.println(node.val+" ");
    }
}
