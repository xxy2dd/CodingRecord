package com.company.leetcode.dp;

/**
 * @author xxy
 * @date 2019/8/28
 * @description
 * 你是一个专业的小偷，计划偷窃沿街的房屋.
 * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，
 * 计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 思路: 动态规划
 * 因为不可以闯入相邻房屋，所以在第n个位置上的可盗窃最大值，
 * 要么是n-1位置上可盗窃的最大值，要么就是n-2房屋可盗窃的最大值加上当前房屋的值
 * 转态转移方程：dp[n] = max(dp[n-1],dp[n-2]+num)
 */
public class rob {
    public int rob(int[] nums){
        if(nums==null||nums.length==0){
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=2;i<=len;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[len];
    }
}
