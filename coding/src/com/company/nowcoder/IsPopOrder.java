package com.company.nowcoder;

import java.util.Stack;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length==0||popA.length==0){
            return false;
        }
        Stack<Integer> s = new Stack<>();
        for(int i = 0, j = 0;i < pushA.length;i++){
            s.push(pushA[i]);
            while(j < popA.length && s.peek()== popA[j]){
                s.pop();
                j++;
            }
        }
        return s.empty();
    }
}
