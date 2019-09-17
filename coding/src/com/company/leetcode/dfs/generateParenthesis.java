package com.company.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xxy
 * @date 2019/8/5
 * @description
 * ����n�����������ŵĶ���������д��һ��������ʹ���ܹ��������п��ܵĲ�����Ч��������ϡ�
 * ���磬����n = 3�����ɽ��Ϊ��
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
