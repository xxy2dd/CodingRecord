package com.company.leetcode.dp;

/**
 * @author xxy
 * @date 2019/7/2
 * @description
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class longestPalindrome {
    /**
     * 方法一：暴力解法
     * 时间复杂度 O（n^3）
     * 空间复杂度 O（n）
     */
    public boolean isPalindromic(String s){
        int len = s.length();
        for(int i = 0;i<len;i++){
            if(s.charAt(i)!=s.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }
    public String longestPalindrom(String s){
        String ans = "";
        int max = 0;
        int len = s.length();
        for(int i=0;i<len;i++){
            for(int j=i+1;j<=len;j++){
                String test = s.substring(i,j);
                if(isPalindromic(test)&&test.length()>max){
                    ans = s.substring(i,j);
                    max = Math.max(max,ans.length());
                }
            }
        }
        return ans;
    }
    /**
     * 方法二：动态规划
     */
    public String longestPalindrom_dp(String s){
        int length = s.length();
        boolean[][] p = new boolean[length][length];
        int maxLen = 0;
        String maxPal = "";
        for(int len = 1;len<=length;len++){
            for(int start = 0;start<length;start++){
                int end = start+len-1;

            }
        }
        return maxPal;
    }
}
