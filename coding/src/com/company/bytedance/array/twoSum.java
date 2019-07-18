package com.company.bytedance.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums==null||nums.length==0){
            return res;
        }
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        for(int i =0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                res[0] = map.get(nums[i]);
                res[1] = i;
                break;
            }
            map.put(target-nums[i],i);
        }
        return res;
    }
}
