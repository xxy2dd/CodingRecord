package com.company.leetcode.tree;

/**
 * @author xxy
 * @date 2019/8/28
 * @description
 */
public class flatten {
    private TreeNode last = null;
    public void flatten(TreeNode root){
        if(root==null){
            return ;
        }
        last = root;
        flatten(root.left);
        if(root!=last){
            last.right = root.right;
            root.right = root.left;
            root.left = null;
            flatten(last.right);
        }else{
            flatten(root.right);
        }
    }
}
