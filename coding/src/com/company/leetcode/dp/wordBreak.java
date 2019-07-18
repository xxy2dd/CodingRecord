package com.company.leetcode.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xxy
 * @date 2019/7/3
 * @description
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 判定?s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 *
 * 思路：动态规划
 * f[i]表示字符串s的前i个字符能否拆分成wordDict。
 */
public class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length()+1];
        f[0] = true;
        Set<String> wordDictSet = new HashSet<>(wordDict);
        for(int i = 0;i<s.length();i++){
            if(!f[i]){
                continue;
            }
            for(String d:wordDictSet){
                if((i+d.length()<=s.length())&&s.substring(i,i+d.length()).equals(d)){
                    f[i+d.length()]=true;
                }
            }
        }
        return f[s.length()];
    }
}
