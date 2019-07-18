package com.company.leetcode.tree;

/**
 * @author xxy
 * @date 2019/7/18
 * @description
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

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
        // 左孩子开始的最长路径
        int left = Math.max(0,helper(node.left));
        // 右孩子开始的最长路径
        int right = Math.max(0,helper(node.right));
        // 计算以root为最高点的最长路径长度，并和之前的max比较
        max = Math.max(max,left+right+node.val);
        // 返回以root为起点的最长路径的长度
        // 对于二叉树有六种可能最大值v,v1,v2,v+v1,v+v2,v+v1+v2
        // 但是只有v，v+v1，v+v2这三个值的最大者才能返回给上一级。因为要形成通往上一层的path，
        return Math.max(0,Math.max(left,right)+node.val);
    }
}
