package com.company.traverse;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author xxy
 * @date 2019/7/7
 * @description
 */
public class postOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        // LinkedList 实现了Deque 双端队列
        LinkedList<Integer> res = new LinkedList<>();
        if(root==null){
            return res;
        }
        // 栈的特点是先进后出
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            // 每次添加元素时都添加到链表的头部
            res.addFirst(curr.val);
            // 左子树入栈
            if(curr.left!=null){
                stack.push(curr.left);
            }
            // 右子树入栈
            if(curr.right!=null){
                stack.push(curr.right);
            }
        }
        return res;
    }
}
