package com.company.leetcode.tree;

/**
 * @author xxy
 * @date 2019/7/7
 * @description
 * ����һ����������һ��Ŀ��ͣ��жϸ������Ƿ���ڸ��ڵ㵽Ҷ�ӽڵ��·��������·�������нڵ�ֵ��ӵ���Ŀ��͡�
 * ˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 * ʾ��:
 * �������¶��������Լ�Ŀ��� sum = 22��
 *  5
 * / \
 * 4  8
 * /  / \
 * 11 13 4
 * / \    \
 * 7  2    1
 * ���� true, ��Ϊ����Ŀ���Ϊ 22 �ĸ��ڵ㵽Ҷ�ӽڵ��·�� 5->4->11->2��
 *
 * ˼·���ݹ� ÿ�ν������ֵ������һ�εݹ��У�ֱ����Ϊ0
 */
public class hasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        // ��ȡ��ǰ����Ҫ��õ�ֵ�Ĵ�С
        int t = sum-root.val;
        // �ݹ��������
        // �ж����������Ƿ�Ϊ�գ�Ϊ��˵��������Ҷ�ӽڵ㣬
        // �жϴ�ʱt==0,Ϊ0��ʾ���ڣ���Ϊ0��ʾ������
        if(root.left==null&&root.right==null){
            return t==0?true:false;
        }
        // ������������������
        return hasPathSum(root.left,t)||hasPathSum(root.right,t);
    }
}
