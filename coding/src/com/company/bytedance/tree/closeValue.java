package com.company.bytedance.tree;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class closeValue {
    public int closestValue(TreeNode root, double target) {
        // ѡ�������ĸ��ڵ�
        TreeNode kid = target < root.val ? root.left : root.right;
        // ���û��������Ҳ���ǵݹ鵽��ʱ��ֱ�ӷ��ص�ǰ�ڵ�ֵ
        if(kid == null) return root.val;
        // �ҳ�������������Ǹ��ڵ�
        int closest = closestValue(kid, target);
        // ���ظ��ڵ����������ڵ��У��������Ǹ��ڵ�
        return Math.abs(root.val - target) < Math.abs(closest - target) ? root.val : closest;
    }
}
