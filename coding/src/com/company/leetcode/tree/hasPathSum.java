package com.company.leetcode.tree;

/**
 * @author xxy
 * @date 2019/7/7
 * @description
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *  5
 * / \
 * 4  8
 * /  / \
 * 11 13 4
 * / \    \
 * 7  2    1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * 思路：递归 每次将还差的值传到下一次递归中，直到差为0
 */
public class hasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        // 获取当前还需要获得的值的大小
        int t = sum-root.val;
        // 递归结束条件
        // 判断左右子树是否为空，为空说明遍历到叶子节点，
        // 判断此时t==0,为0表示存在，不为0表示不存在
        if(root.left==null&&root.right==null){
            return t==0?true:false;
        }
        // 遍历左子树和右子树
        return hasPathSum(root.left,t)||hasPathSum(root.right,t);
    }
}
