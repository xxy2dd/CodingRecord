package com.company.bytedance.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int start = 0;
        Map<Character,Integer> map = new HashMap();
        for(int i = 0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                start =Math.max(map.get(s.charAt(i))+1,start);
            }
            map.put(s.charAt(i),i);
            len = Math.max(len,i-start+1);
        }
        return len;

    }
}
