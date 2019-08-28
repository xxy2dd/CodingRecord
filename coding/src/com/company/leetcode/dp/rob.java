package com.company.leetcode.dp;

/**
 * @author xxy
 * @date 2019/8/28
 * @description
 * ����һ��רҵ��С͵���ƻ�͵���ؽֵķ���.
 * ÿ�䷿�ڶ�����һ�����ֽ�Ӱ����͵�Ե�Ψһ��Լ���ؾ������ڵķ���װ���໥��ͨ�ķ���ϵͳ��
 * ����������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������
 * ����һ������ÿ�����ݴ�Ž��ķǸ��������飬
 * �������ڲ���������װ�õ�����£��ܹ�͵�Ե�����߽�
 *
 * ˼·: ��̬�滮
 * ��Ϊ�����Դ������ڷ��ݣ������ڵ�n��λ���ϵĿɵ������ֵ��
 * Ҫô��n-1λ���Ͽɵ��Ե����ֵ��Ҫô����n-2���ݿɵ��Ե����ֵ���ϵ�ǰ���ݵ�ֵ
 * ת̬ת�Ʒ��̣�dp[n] = max(dp[n-1],dp[n-2]+num)
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
