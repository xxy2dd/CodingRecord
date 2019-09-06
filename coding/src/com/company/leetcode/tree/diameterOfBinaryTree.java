package com.company.leetcode.tree;

/**
 * @author xxy
 * @date 2019/9/1
 * @description
 * ����һ�ö�����������Ҫ��������ֱ�����ȡ�
 * һ�ö�������ֱ�������������������·�������е����ֵ��
 * ����·�����ܴ�������㡣
 */
public class diameterOfBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        max = max>(left+right)?max:left+right;
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return max;
    }
    private int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(getDepth(root.left),getDepth(root.right))+1;
    }

    public int diameterOfBinaryTree2(TreeNode root) {
        getDepth2(root);
        return max;
    }
    private int getDepth2(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = getDepth2(root.left);
        int right = getDepth2(root.right);
        max = max>(left+right)?max:left+right;
        return left>right?left+1:right+1;
    }
}
