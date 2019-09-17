package com.company.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xxy
 * @date 2019/8/5
 * @description
 * 给出n代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出n = 3，生成结果为：
 * ["((()))","(()())","(())()","()(())","()()()"]
 *
 */
public class generateParenthesis {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        add("",0,0,n);
        return res;
    }
    public void add(String s,int left,int right,int n){
        if(s.length()==2*n){
            res.add(s);
            return ;
        }
        if(left<n){
            add(s+"(",left+1,right,n);
        }
        if(left>right){

            add(s+")",left,right+1,n);
        }
    }
}
