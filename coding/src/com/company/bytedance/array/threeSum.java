package com.company.bytedance.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * 给定一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
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
