package com.company.bytedance.dporgreedy;

/**
 * @author xxy
 * @date 2019/7/2
 * @description
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 */
public class maxProfit {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int min = prices[0];
        int profit = 0;
        for(int i : prices){
            // 记录i之前的最小值
            if(i<min){
                min = i;
            }
            // 计算当前利润并更新
            profit = Math.max(profit,i-min);
        }
        return profit;
    }
}
