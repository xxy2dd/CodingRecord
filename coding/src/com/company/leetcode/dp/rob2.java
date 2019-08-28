package com.company.leetcode.dp;

/**
 * @author xxy
 * @date 2019/8/28
 * @description
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

 */
public class rob2 {
    public int rob(int[] nums){
       if(nums==null||nums.length==0){
           return 0;
       }
       int len = nums.length;
       if(len==1){
           return nums[0];
       }
       if(len==2){
           return nums[0]>nums[1]?nums[0]:nums[1];
       }
       return Math.max(help(nums,0,len-2),help(nums,1,len-1));
    }
    private int help(int[] nums,int start,int end){
        int[] dp = new int[end-start+1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start+1],nums[start]);
        for(int i=start+2;i<=end;i++){
            dp[i-start] = Math.max(dp[i-start-1],dp[i-start-2]+nums[i]);
        }
        return dp[end-start];
    }
}
