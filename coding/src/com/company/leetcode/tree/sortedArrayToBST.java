package com.company.leetcode.tree;


/**
 * @author xxy
 * @date 2019/9/6
 * @description
 * ��һ�������������е��������飬ת��Ϊһ�ø߶�ƽ�������������
 * �����У�һ���߶�ƽ���������ָһ��������ÿ���ڵ� ���������������ĸ߶Ȳ�ľ���ֵ������ 1
 *
 * ˼·�����ص㣺�������е��������飬���뵽��������������������պ�����������
 * ��Ŀת��Ϊ���������������ԭһ��������ֻ��һ�ֱ��������޷�ȷ�����ڵ�
 * �����ڱ����У�Ҫ������ת��Ϊһ��ƽ�����������������ֻҪ�Ѹ��ڵ�ѡΪ������е㼴��
 */
public class sortedArrayToBST {
    /**
     * �ݹ�
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0){
            return null;
        }
        return sortedArrayToBST(nums,0,nums.length-1);
    }
    private TreeNode sortedArrayToBST(int[] nums,int start,int end){
        if(start>end){
            return null;
        }
        int mid = start+(end-start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums,start,mid-1);
        root.right = sortedArrayToBST(nums,mid+1,end);
        return root;
    }

}
