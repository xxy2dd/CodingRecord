package com.company.bytedance.tree;


import java.util.LinkedList;
import java.util.List;

/**
 * @author xxy
 * @date 2019/6/30
 * @description 思路：层次遍历
 * 利用LinkedList 可在头结点直接插入
 */
public class zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        printZhiOrder(res, root, 0);
        return res;
    }

    private void printZhiOrder(List<List<Integer>> res, TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        // 很巧妙的地方 res.size 和 depth 的关系
        if (res.size() <= depth) {
            res.add(new LinkedList<>());
        }
        // 奇数层头部插入实现序列逆序 先进后出
        if (depth % 2 != 0) {
            res.get(depth).add(0, node.val);
        }
        // 偶数层顺次插入  先进先出
        else {
            res.get(depth).add(node.val);
        }
        printZhiOrder(res, node.left, depth + 1);
        printZhiOrder(res, node.right, depth + 1);
    }
}
