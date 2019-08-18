package com.company.leetcode.string;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author xxy
 * @date 2019/8/18
 * @description
 */
public class isValid {
    public static void main(String[] args){
        String s = "([)]";
        boolean res = isValid(s);
        System.out.println(res);
    }
    public static boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if (topElement != map.get(c)) {
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
