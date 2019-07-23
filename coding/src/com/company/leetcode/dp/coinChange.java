package com.company.leetcode.dp;

import com.company.nowcoder.Match;

import java.util.Arrays;

/**
 * @author xxy
 * @date 2019/7/23
 * @description ������ͬ����Ӳ�� coins ��һ���ܽ�� amount��
 * ��дһ��������������Դճ��ܽ����������ٵ�Ӳ�Ҹ��������û���κ�һ��Ӳ�����������ܽ�����-1��
 * ˼·����̬�滮�������ڱ������⣬̰�Ĳ��ԣ���̰���㷨ĳЩ����²�����
 */
public class coinChange {
    public static void main(String[] args) {
        coinChange c = new coinChange();
        int[] coins = {186, 419, 83, 408};
        int amount = 6249;
        c.coinChange(coins, amount);
    }
    int result = Integer.MAX_VALUE;
    // DFS+��֦
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        // ������
        Arrays.sort(coins);
        helper(coins, amount, coins.length - 1, 0);
        return result==Integer.MAX_VALUE?-1:result;
    }
    private void helper(int[] coins,int target,int idx,int cur){
        // ���е�������������
        if(idx<0){
            return;
        }
        // �ҵ���� һ��һ�㷵�ػ�ȥ
        if(target%coins[idx]==0){
            result = Math.min(result,cur+target/coins[idx]);
            return;
        }
        for(int i=target/coins[idx];i>=0;i--){
            // Ԥ�е������Ž⣬��ֹ�ݹ�
            if(cur+i>=result-1){
                return;
            }
            // ʣ�µ�Ǯ target-i*coins[idx]����Ѷһ���ʽ
            helper(coins,target-i*coins[idx],idx-1,cur+i);
        }
    }

    public int coinChange2(int[] coins, int amount) {
        // ��̬�滮  ������Դճ�amount�ܽ����������ٵ�Ӳ�Ҹ��� ����ת���� ���Դճ�amount-coins[coins.length-1]�ܽ�����������Ӳ�Ҹ���
        // �� dp[i] = min(dp[i],dp[i-coins[j])
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
