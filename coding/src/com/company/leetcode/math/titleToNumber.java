package com.company.leetcode.math;

/**
 * @author xxy
 * @date 2019/9/12
 * @description
 */
public class titleToNumber {
    public int titleToNumber(String  s){
        int ans = 0;
        for(int i=0;i<s.length();i++){
            int num = s.charAt(i)-'A'+1;
            ans = ans*26 + num;
        }
        return ans;
    }
}
