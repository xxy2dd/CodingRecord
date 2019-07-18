package com.company.leetcode.tree;

/**
 * @author xxy
 * @date 2019/7/7
 * @description
 * ����һ��������, �ҵ�����������ָ���ڵ������������ȡ�
 * �ٶȰٿ�������������ȵĶ���Ϊ��
 * �������и��� T ��������� p��q������������ȱ�ʾΪһ����� x������ x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����

 */
public class lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //����Ŀ��ڵ���ͨ������ֵ��Ǹ�����������ĳ��Ŀ����
        if(root == null || root == p || root == q){
            return root;
        }
        //�鿴���������Ƿ���Ŀ���㣬û��Ϊnull
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //�鿴�������Ƿ���Ŀ��ڵ㣬û��Ϊnull
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //����Ϊ�գ�˵��������������Ŀ���㣬�򹫹����Ⱦ��Ǳ���
        if(left != null && right != null){
            return root;
        }
        //���û������Ŀ��ڵ㣬��������ϱ��Ϊ��Ŀ��ڵ�
        return left == null ? right : left;

    }
}
