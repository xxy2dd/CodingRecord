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
public class inOrderTraversal {
    /**
     * �ȷ������������ٻ��˵����ڵ㣬�ٷ��ʸ��ڵ���������������һ���ѵ��Ǵ����������˵����ڵ�Ĳ�����
     * ��Ȼ������ջ��ʵ�ֻ��ˣ�����Ҫע���ڳ�ջʱ������ڵ�����ã���Ϊ���ǻ���Ҫͨ�����ڵ���������������
     * @param root
     * @return
     */
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr!=null||!stack.isEmpty()){
            // һֱ�����ڵ� ֪����ڵ�Ϊ��
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            // ��ʱջ��Ԫ�ؼ�Ϊ����ڵ㣬ȡ��
            curr = stack.pop();
            // ���ڵ�ֵ����������
            res.add(curr.val);
            // ��Ӹýڵ���ҽڵ�
            curr = curr.right;

        }
        return res;

    }

    /**
     * Mirros �㷨
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                result.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode rightmost = cur.left;
                while (rightmost.right != null) {
                    // Ѱ�������������ҽڵ�
                    rightmost = rightmost.right;
                }
                // ��ǰ�ڵ���Ϊ�����������ҽڵ���Һ���
                rightmost.right = cur;
                TreeNode oldRoot = cur;
                // ����������Ϊ�µĶ���ڵ�
                cur = cur.left;
                // ��������������ֹ��������ѭ��
                oldRoot.left = null;
            }
        }
        return result;
    }
}
