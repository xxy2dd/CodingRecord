package com.company.leetcode.dp;

/**
 * @author xxy
 * @date 2019/7/1
 * @description
 * 给定?n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 方法一 ： 动态规划
 * 方法二 ：左右夹
 */
public class trapRain {
    public int trap(int[] height) {
        int len = height.length;
        if (len < 3)
            return 0;
        int ans = 0;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = height[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        right[len - 1] = height[len - 1];
        for (int i = len - 2; i > -1 ; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
            ans += Math.min(right[i],left[i]) - height[i];
        }
        return ans;

    }
    public int trap2(int[] height) {
        if(height.length<=2){
            return 0;
        }
        int res = 0,maxHeight = height[0],maxIndex = 0;
        // 找到中间最高的点 记录高度及下标
        for(int i=0;i<height.length;i++){
            if(height[i]>maxHeight){
                maxHeight = height[i];
                maxIndex = i;
            }
        }
        // 找左边
        int maxLeft = 0;
        for(int i = 0;i<maxIndex;i++){
            if(height[i]>maxLeft){
                maxLeft = height[i];
            }else{
                res +=(maxLeft-height[i]);
            }
        }
        // 找右边
        int maxRight = 0;
        for(int i=height.length-1;i>maxIndex;i--){
            if(height[i]>maxRight){
                maxRight = height[i];
            }else{
                res += (maxRight-height[i]);
            }
        }
        return res;

    }
}
