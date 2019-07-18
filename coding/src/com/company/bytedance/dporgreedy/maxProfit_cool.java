package com.company.bytedance.dporgreedy;

/**
 * @author xxy
 * @date 2019/7/18
 * @description
 * 给定一个整数数组，其中第i个元素代表了第i天的股票价格 。?
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 * 示例:
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * 思路： 动态规划
 * 状态转移方程：
 * sell[i] 表示第 i 天时未持有股票可获得的最大利润。buy[i] 表示第 i 天时持有股票可获得的最大利润。
 * 对于 sell[i]，最大利润有两种可能，一是今天依旧不持股跟昨天状态一样；二是今天卖了股票
 * 对于 buy[i]，最大利润有两种可能，一是今天持股跟昨天状态一样；二是前天卖了股票，今天买入股票。
 * 因为存在 cooldown 的原因，所以今天买股票要追溯到前天的状态，
 * 最终的结果为最后一天不持有股票的状态，即 sell[n - 1]。
 *
 * sell[i] = Math.max(sell[i-1],buy[i-1]+prices[i]);
 * cooldown[i] = sell[i-1];
 * buy[i] = Math.max(buy[i-1],cooldown[i-1]-prices[i]);
 */
public class maxProfit_cool {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int len = prices.length;
        int[] sell = new int[len];
        int[] cooldown = new int[len];
        int[] buy = new int[len];
        sell[0] = 0;
        buy[0] = -prices[0];
        for(int i=1;i<len;i++){
            sell[i] = Math.max(sell[i-1],buy[i-1]+prices[i]);
            cooldown[i] = sell[i-1];
            buy[i] = Math.max(buy[i-1],cooldown[i-1]-prices[i]);
        }
        return Math.max(sell[len-1],cooldown[len-1]);
    }
}
