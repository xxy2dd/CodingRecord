package com.company.leetcode.tree;

/**
 * @author xxy
 * @date 2019/7/19
 * @description
 * ����һ��������������Binary Search Tree��������ת����Ϊ�ۼ�����Greater Tree)��
 * ʹ��ÿ���ڵ��ֵ��ԭ���Ľڵ�ֵ�������д������Ľڵ�ֵ֮�͡�
 *
 * ˼·���ȱ��������� �ۼ�ֵ ���ۼƸ���������
 */
public class convertBST {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null) {
            return root;
        }
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }
}
