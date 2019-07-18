package com.company.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xxy
 * @date 2019/7/8
 * @description
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数.
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。

 */
public class isValidBST {
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 我们可以设置上下bound，递归左右子树时，为它们设置最大值，最小值，并且不可以超过。
     * 注意：下一层递归时，需要把本层的up 或是down继续传递下去。相当巧妙的算法。
     * @param root
     * @param min
     * @param max
     * @return
     */
    public boolean isValidBST(TreeNode root,long min, long max){
        if(root == null) {
            return true;
        }

        if(root.val <= min || root.val >= max) {
            return false;
        }

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    /**
     * 思路二：中序遍历，判断得到的序列是不是递增的
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return true;
        }
        inOrder(root,list);
        for(int i =0;i<list.size()-1;i++){
            if(list.get(i)>=list.get(i+1)){
                return false;
            }
        }
        return true;
    }
    public void inOrder(TreeNode node,List<Integer> list){
        if(node==null){
            return ;
        }
        inOrder(node.left,list);
        list.add(node.val);
        inOrder(node.right,list);
    }

}
