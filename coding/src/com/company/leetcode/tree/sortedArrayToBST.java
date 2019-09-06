package com.company.leetcode.tree;


/**
 * @author xxy
 * @date 2019/9/6
 * @description
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
 *
 * 思路：划重点：升序排列的有序数组，联想到二叉搜索树的中序遍历刚好是升序数组
 * 题目转换为：根据中序遍历还原一棵树，但只有一种遍历我们无法确定根节点
 * 但是在本题中，要求我们转换为一个平衡二叉树，所以我们只要把根节点选为数组的中点即可
 */
public class sortedArrayToBST {
    /**
     * 递归
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0){
            return null;
        }
        return sortedArrayToBST(nums,0,nums.length-1);
    }
    private TreeNode sortedArrayToBST(int[] nums,int start,int end){
        if(start>end){
            return null;
        }
        int mid = start+(end-start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums,start,mid-1);
        root.right = sortedArrayToBST(nums,mid+1,end);
        return root;
    }

}
