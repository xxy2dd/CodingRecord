package com.company.bytedance.tree;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * 在二叉搜索树中找到目标差值最近的节点。
 *
 * 思路一：二叉搜索树的特点就是左节点的值小于根节点，右节点大于根节点
 * 二叉搜索树的中序遍历就是顺序输出二叉搜索树，所以我们只要中序遍历二叉搜索树，
 * 然后用一个Map记录当前最小的距离和对应的节点
 *
 * 思路二：递归（树相关的算法题的常规思路）
 */
public class closeValue {
    public int closestValue(TreeNode root, double target) {
        // 选出子树的根节点
        TreeNode kid = target < root.val ? root.left : root.right;
        // 如果没有子树，也就是递归到底时，直接返回当前节点值
        if(kid == null) return root.val;
        // 找出子树中最近的那个节点
        int closest = closestValue(kid, target);
        // 返回根节点和子树最近节点中，更近的那个节点
        return Math.abs(root.val - target) < Math.abs(closest - target) ? root.val : closest;
    }
}
