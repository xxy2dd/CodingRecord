package com.company.traverse;


/**
 * @author xxy
 * @date 2019/7/7
 * @description
 */
public class preOrderRecursion {
    public void preOrderRecursion(TreeNode node){
        //������Ϊ���򷵻�
        if(node==null) {
            return;
        }
        //���ʸ��ڵ�
        visit(node);
        //��������
        preOrderRecursion(node.left);
        //�����Һ���
        preOrderRecursion(node.right);
    }

    private void visit(TreeNode node){
        System.out.println(node.val+" ");
    }


}
