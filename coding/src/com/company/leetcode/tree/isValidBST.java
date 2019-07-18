package com.company.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xxy
 * @date 2019/7/8
 * @description
 * ����һ�����������ж����Ƿ���һ����Ч�Ķ�����������
 * ����һ��������������������������
 * �ڵ��������ֻ����С�ڵ�ǰ�ڵ����.
 * �ڵ��������ֻ�������ڵ�ǰ�ڵ������
 * �������������������������Ҳ�Ƕ�����������

 */
public class isValidBST {
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * ���ǿ�����������bound���ݹ���������ʱ��Ϊ�����������ֵ����Сֵ�����Ҳ����Գ�����
     * ע�⣺��һ��ݹ�ʱ����Ҫ�ѱ����up ����down����������ȥ���൱������㷨��
     * @param root
     * @param min
     * @param max
     * @return
     */
    public boolean isValidBST(TreeNode root,long min, long max){
        if(root == null) {
            return true;
        }

        if(root.val <= min || root.val >= max) {
            return false;
        }

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    /**
     * ˼·��������������жϵõ��������ǲ��ǵ�����
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return true;
        }
        inOrder(root,list);
        for(int i =0;i<list.size()-1;i++){
            if(list.get(i)>=list.get(i+1)){
                return false;
            }
        }
        return true;
    }
    public void inOrder(TreeNode node,List<Integer> list){
        if(node==null){
            return ;
        }
        inOrder(node.left,list);
        list.add(node.val);
        inOrder(node.right,list);
    }

}
