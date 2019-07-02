package com.company.bytedance.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * ����һ������ n ������������ nums��
 * �ж� nums ���Ƿ��������Ԫ�� a��b��c ��ʹ�� a + b + c = 0 ��
 * �ҳ��������������Ҳ��ظ�����Ԫ�顣
 * ע�⣺���в����԰����ظ�����Ԫ�顣
 */
public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums==null||nums.length<3){
            return res;
        }
        Arrays.sort(nums);
        for(int i= 0;i<nums.length-2;i++){
            if(nums[i]>0) break;
            if(i!=0&&nums[i]==nums[i-1]){
                continue;
            }
            int reverse = -nums[i];
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                if(nums[j]+nums[k]==reverse){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    j++;
                    while(j<k&&nums[j]==nums[j-1]){
                        j++;
                    }
                    k--;
                    while(j<k&&nums[k]==nums[k+1]){
                        k--;
                    }

                }else if(nums[j]+nums[k]<reverse){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return res;

    }
}
