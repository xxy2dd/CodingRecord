package com.company.leetcode.tree;

import com.company.leetcode.tree.TreeNode;

/**
 * @author xxy
 * @date 2019/8/31
 * @description
 * ���ϴδ����һ���ֵ�֮���һȦ���ݺ�С͵�ַ�����һ���µĿ����Եĵ�����
 * �������ֻ��һ����ڣ����ǳ�֮Ϊ�������� ���ˡ�����֮�⣬ÿ����������ֻ��һ��������������֮������
 * һ�����֮�󣬴�����С͵��ʶ��������ط������з��ݵ�����������һ�ö���������
 * �������ֱ�������ķ�����ͬһ�����ϱ���٣����ݽ��Զ�������
 * �����ڲ���������������£�С͵һ���ܹ���ȡ����߽�

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
        // ���������ڵ㣬���ֵ��Ϊ�����������ֵ֮��
        res[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        // �������ڵ㣬���ֵΪ�����������������ڵ�����ֵ���ϸ��ڵ��ֵ
        res[1] = root.val+left[0]+right[0];
        return res;
    }
}
