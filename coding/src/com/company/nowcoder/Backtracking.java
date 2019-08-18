package com.company.nowcoder;

import java.util.ArrayList;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * 输入一颗二叉树的根节点和一个整数，
 * 打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * 思路：递归
 */
public class Backtracking {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        backtracking(root,target,new ArrayList<Integer>());
        return result;
    }
    private void backtracking(TreeNode node,int target,ArrayList<Integer> path){
        if(node==null){
            return;
        }
        path.add(node.val);
        // 放入当前节点后计算还差的值
        target -= node.val;
        //  到达叶子节点 并且满足条件
        if(target==0&&node.left==null&&node.right==null){
            result.add(new ArrayList<>(path));
        }else{
            // 递归左子树和右子树
            backtracking(node.left,target,path);
            backtracking(node.right,target,path);
        }
        // 没有满足条件的就移除当前节点
        path.remove(path.size()-1);
    }
}
