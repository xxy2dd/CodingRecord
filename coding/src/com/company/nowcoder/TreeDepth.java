package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class TreeDepth {
    public int TreeDepth(TreeNode root) {
        return root==null?0:1+Math.max(TreeDepth(root.left),TreeDepth(root.right));
    }
}
