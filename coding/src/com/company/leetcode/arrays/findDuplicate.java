package com.company.leetcode.arrays;

import java.util.HashSet;

/**
 * @author xxy
 * @date 2019/8/30
 * @description
 */
public class findDuplicate {
    public int findDuplicate(int[] nums) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int len = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<len;i++){
            if(set.contains(nums[i])){
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;

    }
}
