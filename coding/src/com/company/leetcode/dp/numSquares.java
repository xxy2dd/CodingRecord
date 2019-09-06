package com.company.leetcode.dp;

/**
 * @author xxy
 * @date 2019/9/1
 * @description
 * ���������� n���ҵ����ɸ���ȫƽ���������� 1, 4, 9, 16, ...��
 * ʹ�����ǵĺ͵��� n������Ҫ����ɺ͵���ȫƽ�����ĸ������١�
 */
public class numSquares {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i=0;i<n+1;i++){
            dp[i] = i;
        }
        for(int i=2;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    // Lagrange ��ƽ������ �κ�һ�������������Ա�ʾ�ɲ������ĸ�������ƽ��֮�͡�
    // ��������ƽ���Ͷ������n������Ҫ�������ĸ������ɣ�С���ĸ����У����ض����� n=4a(8b+7)

    public int numSquares2(int n) {
        while(n%4 ==0){
            n /= 4;
        }
        while(n%8 == 7){
            return 4;
        }
        int a = 0;
        while (a*a <= n){
            int b = (int)(Math.sqrt(n - a*a));
            if (a*a + b*b == n){
                if(a== 0 || b==0){
                    return 1;
                }
                return 2;
            }
            a+=1;
        }
        return 3;
    }
}
