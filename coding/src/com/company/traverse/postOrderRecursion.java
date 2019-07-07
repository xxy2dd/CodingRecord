package com.company.traverse;

/**
 * @author xxy
 * @date 2019/7/7
 * @description
 */
public class postOrderRecursion {
    public void postOrderRecursion(TreeNode node){
        //������Ϊ���򷵻�
        if(node==null) {
            return;
        }
        //��������
        postOrderRecursion(node.left);
        //�����Һ���
        postOrderRecursion(node.right);
        //���ʸ��ڵ�
        visit(node);
    }
    private void visit(TreeNode node){
        System.out.println(node.val+" ");
    }
}
