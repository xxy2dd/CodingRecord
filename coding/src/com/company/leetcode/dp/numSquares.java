package com.company.leetcode.dp;

/**
 * @author xxy
 * @date 2019/9/1
 * @description
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）
 * 使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
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

    // Lagrange 四平方定理： 任何一个正整数都可以表示成不超过四个整数的平方之和。
    // 满足四数平方和定理的数n（这里要满足由四个数构成，小于四个不行），必定满足 n=4a(8b+7)

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
