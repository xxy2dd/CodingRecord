package com.company.bytedance.dporgreedy;

/**
 * @author xxy
 * @date 2019/7/2
 * @description
 */
public class maxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int[] res = new int[nums.length];
        res[0] = nums[0];
        int maxSum = nums[0];
        for(int i =1;i<nums.length;i++){
            if(res[i-1]>0){
                res[i] = res[i-1]+nums[i];
            }else{
                res[i] = nums[i];
            }
            if(res[i]>maxSum){
                maxSum = res[i];
            }
        }
        return maxSum;
    }
    public int maxSubArray2(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for(int n:nums){
            sum = sum<=0?n:n+sum;
            max = Math.max(max,sum);
        }
        return max;
    }
}
