package com.company.leetcode.dp;

/**
 * @author xxy
 * @date 2019/7/2
 * @description
 * ����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ��� s ����󳤶�Ϊ 1000��
 */
public class longestPalindrome {
    /**
     * ����һ�������ⷨ
     * ʱ�临�Ӷ� O��n^3��
     * �ռ临�Ӷ� O��n��
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
     * ����������̬�滮
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
