package com.company.leetcode.tree;

/**
 * @author xxy
 * @date 2019/7/19
 * @description
 * ��תһ�ö�������
 * �ݹ飡 ���������໥����
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
