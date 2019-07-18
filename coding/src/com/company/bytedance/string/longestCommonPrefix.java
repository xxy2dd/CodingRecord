package com.company.bytedance.string;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 */
public class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        int index = 0;
        // 以第一个字符串为标准
        for (int i = 0;i<strs[0].length();i++){
            // 当前字符
            char current = strs[0].charAt(index);
            // 遍历字符串数组
            for (String str:strs){
                // 如果这个字符串的长度和当前遍历的长度相等或者当前字符和该字符串的对应位置字符不一致
                // 返回这个字符的（0，index）子字符串
                if (str.length()== i || current!=str.charAt(i)){
                    return str.substring(0,index);
                }
            }
            index++;
        }
        // 遍历完了还没有返回，说明第一个字符串就是最长公共前缀
        return strs[0].substring(0, index);
    }
}
