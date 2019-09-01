package com.company.leetcode.dp;

import java.util.Arrays;

/**
 * @author xxy
 * @date 2019/8/31
 * @description 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 */
public class lengthOfLIS {
    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums==null||nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 贪心+二分查找
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {

        if(nums==null||nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int[] temp = new int[len];
        temp[0] = nums[0];
        int end = 0;
        for(int i = 1;i < len ; i++){
            if(nums[i] > temp[end]){
                end++;
                temp[end] = nums[i];
            }else{
                int left = 0;
                int right = end;
                while(left < right){
                    int mid = (left + right)/2;
                    if(temp[mid] < nums[i]){
                        left = mid + 1;
                    }else{
                        right =mid;
                    }
                }
                temp[left] = nums[i];
            }
        }
        return end + 1;
    }
}
