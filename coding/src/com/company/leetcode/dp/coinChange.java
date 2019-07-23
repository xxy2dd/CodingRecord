package com.company.leetcode.dp;

import com.company.nowcoder.Match;

import java.util.Arrays;

/**
 * @author xxy
 * @date 2019/7/23
 * @description 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
 * 思路：动态规划，类似于背包问题，贪心策略，但贪心算法某些情况下不成立
 */
public class coinChange {
    public static void main(String[] args) {
        coinChange c = new coinChange();
        int[] coins = {186, 419, 83, 408};
        int amount = 6249;
        c.coinChange(coins, amount);
    }
    int result = Integer.MAX_VALUE;
    // DFS+剪枝
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        // 先排序
        Arrays.sort(coins);
        helper(coins, amount, coins.length - 1, 0);
        return result==Integer.MAX_VALUE?-1:result;
    }
    private void helper(int[] coins,int target,int idx,int cur){
        // 所有的数都遍历完了
        if(idx<0){
            return;
        }
        // 找到组合 一层一层返回回去
        if(target%coins[idx]==0){
            result = Math.min(result,cur+target/coins[idx]);
            return;
        }
        for(int i=target/coins[idx];i>=0;i--){
            // 预判低于最优解，终止递归
            if(cur+i>=result-1){
                return;
            }
            // 剩下的钱 target-i*coins[idx]的最佳兑换方式
            helper(coins,target-i*coins[idx],idx-1,cur+i);
        }
    }

    public int coinChange2(int[] coins, int amount) {
        // 动态规划  计算可以凑成amount总金额所需的最少的硬币个数 可以转换成 可以凑成amount-coins[coins.length-1]总金额所需的最少硬币个数
        // 即 dp[i] = min(dp[i],dp[i-coins[j])
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}
