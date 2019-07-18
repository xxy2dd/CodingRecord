package com.company.leetcode.tree;

/**
 * @author xxy
 * @date 2019/7/18
 * @description
 * ����һ���ǿն����������������·���͡�
 * �����У�·��������Ϊһ������������ڵ�������ﵽ����ڵ�����С���·�����ٰ���һ���ڵ㣬�Ҳ�һ���������ڵ㡣

 */
public class maxPathSum {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        helper(root);
        return max;
    }
    public int helper(TreeNode node){
        if(node==null){
            return 0;
        }
        // ���ӿ�ʼ���·��
        int left = Math.max(0,helper(node.left));
        // �Һ��ӿ�ʼ���·��
        int right = Math.max(0,helper(node.right));
        // ������rootΪ��ߵ���·�����ȣ�����֮ǰ��max�Ƚ�
        max = Math.max(max,left+right+node.val);
        // ������rootΪ�����·���ĳ���
        // ���ڶ����������ֿ������ֵv,v1,v2,v+v1,v+v2,v+v1+v2
        // ����ֻ��v��v+v1��v+v2������ֵ������߲��ܷ��ظ���һ������ΪҪ�γ�ͨ����һ���path��
        return Math.max(0,Math.max(left,right)+node.val);
    }
}
