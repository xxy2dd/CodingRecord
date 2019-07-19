package com.company.leetcode.tree;

/**
 * @author xxy
 * @date 2019/7/19
 * @description
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 思路：先遍历右子树 累加值 再累计根和左子树
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
