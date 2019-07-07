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
        // LinkedList ʵ����Deque ˫�˶���
        LinkedList<Integer> res = new LinkedList<>();
        if(root==null){
            return res;
        }
        // ջ���ص����Ƚ����
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            // ÿ�����Ԫ��ʱ����ӵ������ͷ��
            res.addFirst(curr.val);
            // ��������ջ
            if(curr.left!=null){
                stack.push(curr.left);
            }
            // ��������ջ
            if(curr.right!=null){
                stack.push(curr.right);
            }
        }
        return res;
    }
}
