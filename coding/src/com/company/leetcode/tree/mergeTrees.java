package com.company.leetcode.tree;

/**
 * @author xxy
 * @date 2019/7/19
 * @description
 * ���������������������㽫�����е�һ�����ǵ���һ����ʱ��������������һЩ�ڵ����ص���
 * ����Ҫ�����Ǻϲ�Ϊһ���µĶ�������
 * �ϲ��Ĺ�������������ڵ��ص�����ô�����ǵ�ֵ�����Ϊ�ڵ�ϲ������ֵ������Ϊ NULL �Ľڵ㽫ֱ����Ϊ�¶������Ľڵ㡣
 */
public class mergeTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null) {
            return t2;
        }
        if(t2==null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }
}
