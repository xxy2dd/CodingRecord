package com.company.nowcoder;

import java.util.Stack;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class QueueByStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        if(!stack2.isEmpty()){
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            while(stack1.size()>1){
                stack2.push(stack1.pop());
            }
            return stack1.pop();
        }else{
            return stack2.pop();
        }

    }
}
