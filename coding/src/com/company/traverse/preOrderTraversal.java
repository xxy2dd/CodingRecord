package com.company.traverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author xxy
 * @date 2019/7/7
 * @description
 */
public class preOrderTraversal {
    /**
     *  ��������ǵݹ�����ջʵ�֣���Ϊջ���������Ƚ���� ����������������ջ ������������ջ
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root==null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left);
            }

        }
        return res;

    }
}
