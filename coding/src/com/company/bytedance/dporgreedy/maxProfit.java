package com.company.bytedance.dporgreedy;

/**
 * @author xxy
 * @date 2019/7/2
 * @description
 */
public class maxProfit {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int min = prices[0];
        int profit = 0;
        for(int i : prices){
            if(i<min){
                min = i;
            }
            profit = Math.max(profit,i-min);
        }
        return profit;
    }
}
