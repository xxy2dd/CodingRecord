package com.company.leetcode.tree;

/**
 * @author xxy
 * @date 2019/7/19
 * @description
 * 翻转一棵二叉树。
 * 递归！ 左右子树相互交换
 */
public class invertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }

        TreeNode temp = root.left;

        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }
}
