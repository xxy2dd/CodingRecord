package com.company.leetcode.tree;

import com.company.leetcode.tree.TreeNode;

/**
 * @author xxy
 * @date 2019/8/31
 * @description
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

 */
public class rob3 {
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0],res[1]);
    }
    public int[] helper(TreeNode root){
        int[] res = new int[2];
        if(root==null){
            return res;
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        // 不包含根节点，最大值即为两棵子树最大值之和
        res[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        // 包含根节点，最大值为两个子树不包含根节点的最大值加上根节点的值
        res[1] = root.val+left[0]+right[0];
        return res;
    }
}
