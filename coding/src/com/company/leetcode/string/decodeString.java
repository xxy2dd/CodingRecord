package com.company.leetcode.string;

import java.util.LinkedList;

/**
 * @author xxy
 * @date 2019/8/18
 * @description
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".

 */
public class decodeString {
    public static void main(String[] args){
        String s = "3[a]2[bc]";
        String res = decodeString(s);
        System.out.println(res);
    }
    /**
     * 辅助栈法
     * 时间复杂度O（n）空间复杂度 O（n）
     */
    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        LinkedList<Integer> countStack = new LinkedList<>();
        LinkedList<String> resStack = new LinkedList<>();
        for(Character c:s.toCharArray()){
            if(c == '['){
                // 将之前计算得到的数字入栈
                countStack.addLast(count);
                // 将之前得到的字母也入栈
                resStack.addLast(sb.toString());
                count = 0;
                sb = new StringBuilder();
            }else if(c == ']'){
                StringBuilder temp = new StringBuilder();
                // 数字出栈
                int curCount = countStack.removeLast();
                // 将累加字母根据数字翻倍
                for(int i=0;i<curCount;i++){
                    temp.append(sb);
                }
                // 将字母出栈，和翻倍字母拼接
                sb = new StringBuilder(resStack.removeLast()+temp);
            }else if(c>='0'&&c<='9'){
                // 计算倍数
                count = count*10+Integer.parseInt(c+"");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
