package com.company.leetcode.bitoperation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xxy
 * @date 2019/8/5
 * @description
 */
public class subsets {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        subsets s = new subsets();
        s.subsets3(nums);
    }
    /**
     * ʹ�ö���������
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        // 1<<num.length �ȼ��� 2^nums.length��������n�����ֵ����鹲��2^n���Ӽ�
        for(int i=0;i<(1<<nums.length);i++){
            List<Integer> sub = new ArrayList<>();
            for(int j = 0;j<nums.length;j++){
                // ���ڶ������� i���ӵ�λ����λ���ȡ�������λ�����ж��Ƿ�Ϊ1��Ϊ1��������nums�е�Ԫ��
                if(((i>>j)&1)==1){
                    sub.add(nums[j]);
                }
            }
            res.add(sub);
        }
        return res;
    }

    /**
     * ����
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            List<List<Integer>> sub = new ArrayList<>();
            for(List<Integer> list: res){
                List<Integer> temp = new ArrayList<>(list);
                // ������������
                temp.add(nums[i]);
                sub.add(temp);
            }
            res.addAll(sub);
        }
        return res;
    }

    /**
     * ����
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets3(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(res,temp,nums,0);
        return res;
    }
    private void helper(List<List<Integer>> res,List<Integer> temp,int[] nums,int level){
        if(temp.size()<=nums.length){
            res.add(new ArrayList<>(temp));
        }
        for(int i=level;i<nums.length;i++){
            temp.add(nums[i]);
            helper(res,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }

    /**
     * DFS
     * @param nums
     * @return
     */
    public  List<List<Integer>> subsets4(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(res,temp,nums,0);
        return res;
    }
    private void dfs(List<List<Integer>> res,List<Integer> temp,int[] nums,int level){
        if(level>=nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[level]);
        dfs(res,temp,nums,level+1);
        temp.remove(temp.size()-1);
        dfs(res,temp,nums,level+1);

    }

}
