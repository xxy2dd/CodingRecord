package com.company.leetcode.string;

/**
 * @author xxy
 * @date 2019/8/28
 * @description
 */
public class countSubstrings {
    // 动态规划

    public int countSubstrings(String s){
        if(s==null||s.length()==0){
            return 0;
        }
        int result = 0;
        boolean[][] dp = buildDPForCountSubstrings(s);
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<=i;j++){
                if(dp[j][i]){
                    result++;
                }
            }
        }
        return result;
    }
    private boolean[][] buildDPForCountSubstrings(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(i==j){
                    dp[i][j]=true;
                }else{
                    dp[i][j]=s.charAt(i)==s.charAt(j)&&(i-j<=1||dp[i-1][j+1]);
                }
            }
        }
        return dp;
    }

    // 中心扩展法
    public int countSubString2(String s){
        int result = 0;
        for(int i=0;i<s.length();i++){
            // 回文长度为奇数
            result+=countSegment(s,i,i);
            // 回文长度为偶数
            result+=countSegment(s,i,i+1);
        }
        return result;
    }
    public int countSegment(String s,int start,int end){
        int count = 0;
        while(start>=0&&end<s.length()&&s.charAt(start--)==s.charAt(end++)){
            count++;
        }
        return count;
    }

}
